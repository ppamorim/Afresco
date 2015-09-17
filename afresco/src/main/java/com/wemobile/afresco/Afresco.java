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

import android.content.Context;
import android.net.Uri;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class Afresco {

  private static volatile Afresco singleton = null;

  private final Context context;
  private ImageRequest imageRequest;

  public Afresco(Context context) {
    this.context = context;
  }

  public static void initialize(Context context) {
    Fresco.initialize(context);
  }

  public static void shutDown() {
    Fresco.shutDown();
  }

  public ImageRequest getImageRequest() {
    return imageRequest;
  }

  public void setImageRequest(ImageRequest imageRequest) {
    this.imageRequest = imageRequest;
  }

  public static Afresco with(Context context) {
    if (singleton == null) {
      synchronized (Afresco.class) {
        if (singleton == null) {
          singleton = new Builder(context).build();
        }
      }
    }
    return singleton;
  }

  public Afresco load(String url) {
    return load(Uri.parse(url));
  }

  public Afresco load(Uri uri) {
    setImageRequest(ImageRequestBuilder.newBuilderWithSource(uri)
        .setImageType(ImageRequest.ImageType.SMALL)
        .build());
    return this;
  }

  public Afresco into(AfrescoView afrescoView) {
    DraweeController draweeController = Fresco.newDraweeControllerBuilder()
        .setImageRequest(imageRequest)
        .setOldController(afrescoView.getController())
        .setAutoPlayAnimations(true)
        .build();
    afrescoView.setController(draweeController);
    return this;
  }

  public static class Builder {

    private final Context context;

    public Builder(Context context) {
      if(context == null) {
        throw new IllegalArgumentException("Context must not be null.");
      }
      this.context = context.getApplicationContext();
    }

    public Afresco build() {
      return new Afresco(this.context);
    }

  }

}
