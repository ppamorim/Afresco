/*
* Copyright (C) 2015 WeMobile
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.wemobile.afresco;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AfrescoRequest {

  private ImageRequest imageRequest;

  public AfrescoRequest(ImageRequest imageRequest) {
    this.imageRequest = imageRequest;
  }

  public List<DraweeController> into(AfrescoView... afrescoViews) {
    LinkedHashSet<DraweeController> draweeControllers = new LinkedHashSet<>(afrescoViews.length);
    for (AfrescoView afrescoView : afrescoViews) {
      draweeControllers.add(into(afrescoView));
    }
    return new ArrayList<>(draweeControllers);
  }

  public DraweeController into(AfrescoView afrescoView) {
    DraweeController draweeController = Fresco.newDraweeControllerBuilder()
        .setImageRequest(imageRequest)
        .setOldController(afrescoView.getController())
        .build();
    afrescoView.setController(draweeController);
    return draweeController;
  }

  public ImageRequest getImageRequest() {
    return imageRequest;
  }

  public void setImageRequest(ImageRequest imageRequest) {
    this.imageRequest = imageRequest;
  }

}
