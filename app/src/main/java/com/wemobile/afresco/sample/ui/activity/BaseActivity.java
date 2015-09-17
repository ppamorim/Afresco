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
package com.wemobile.afresco.sample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.wemobile.afresco.Afresco;
import com.wemobile.afresco.AfrescoView;
import com.wemobile.afresco.sample.R;

public class BaseActivity extends AppCompatActivity {

  @Bind(R.id.afresco_view) AfrescoView afrescoView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_base);
    ButterKnife.bind(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    Afresco.with(this).load("http://frescolib.org/static/fresco-hero-logo.png").into(afrescoView);
  }

}
