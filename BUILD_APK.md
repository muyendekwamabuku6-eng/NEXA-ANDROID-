# Building the APK

The project is prepared for Android Gradle Plugin 8.7.3 and compileSdk 35.

In Android Studio:
- Open this project folder.
- Let Gradle finish syncing.
- Select Build > Build Bundle(s) / APK(s) > Build APK(s).
- The debug APK will normally appear under:
  app/build/outputs/apk/debug/app-debug.apk

Do not publish the debug APK to Google Play. A production release needs signing, testing, privacy/legal materials, and store configuration.