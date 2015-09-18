# Afresco
Auto-Fresco wrapper!

[![Build Status](https://api.travis-ci.org/We-Mobile/Afresco.svg)](https://travis-ci.org/We-Mobile/Afresco)
[![JitPack](https://img.shields.io/github/release/ppamorim/Afresco.svg?label=JitPack)](https://jitpack.io/#ppamorim/afresco)

https://img.shields.io/github/release/ppamorim/Afresco.svg?label=JitPack

Fresco can be a complicated library, but Afresco will help you to load images without any pain!

Usage
-----

Add this on your build.gradle

```groovy
repositories {
  maven { url "https://jitpack.io" }
}

dependencies {
  compile 'com.github.ppamorim:afresco:1.0'
}
```

Initialize Fresco instance on your application class

```java
public class YourApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Afresco.initialize(this);
  }

  @Override public void onTerminate() {
    Afresco.shutDown();
    super.onTerminate();
  }

}
```

Load th images with:

```java
Afresco.init()
  .load("http://doge.org/doge/doge.png")
  .into(afrescoView);
```

Add this at your AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

Contributors
------------

* [Pedro Paulo de Amorim][3]

Developed By
------------

* Pedro Paulo de Amorim - <pp.amorim@hotmail.com>

<a href="https://www.linkedin.com/profile/view?id=185411359">
  <img alt="Add me to Linkedin" src="http://imageshack.us/a/img41/7877/smallld.png" />
</a>

Libraries used on the sample project
------------------------------------

* [Butterknife][5]

License
-------

    Copyright 2015 Pedro Paulo de Amorim

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[3]: https://github.com/ppamorim/
[5]: https://github.com/JakeWharton/butterknife