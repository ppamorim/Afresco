# Afresco
Auto-Fresco wrapper!

[![Build Status](https://api.travis-ci.org/We-Mobile/Afresco.svg)](https://travis-ci.org/We-Mobile/Afresco)

Fresco can be a complicated library, but Afresco will help you to load images without any pain!

Usage
-----

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
6
```java
Afresco.init()
  .load("http://doge.org/doge/doge.png")
  .into(afrescoView);
```

Add this at your AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```