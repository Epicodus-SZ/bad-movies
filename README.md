Creation Steps to Create a API connected Android app.

1. Create a new AS project, with an Empty activity
2. ADD GRADLE.PROPERTIES TO .GITIGNORE: Make sure this file is in your .gitignore file before adding files.
3. Create a github repo and connect to the project.
4. Push to the repo
5. Add latest OkHttp to dependencies `compile 'com.squareup.okhttp3:okhttp:3.9.0'`
6. Add Internet permissions to the AndroidManifest.xml `<uses-permission android:name="android.permission.INTERNET"/>`
7. Download Postman and test your API's to call
8. Create models, services and ui packages.  Move MainActivity to the ui package.
9. ADD SECRETS TO GRADLE.PROPERTIES: Put your API key values in the file gradle.properties looking like this `StevesLastName = "Zaske"`

*You might want to email yourself a copy of the gradle.properties file, so you can reproduce the app.*
10. EDIT BUILD.GRADLE FILE: Then add a line in your build.gradle file (Module:app) that looks like this

```
    android {
        buildTypes.each {
            it.buildConfigField 'String', 'STEVES_LAST_NAME', StevesLastName
        ```
 This tells gradle to auto generate these Static Strings in the ***BuildConfig.java*** file.

11. CREATE A CONSTANTS.JAVA CLASS. Create a new class called Constants.java and add a line like:
`public static final String STEVES_LAST_NAME = BuildConfig.STEVES_LAST_NAME;`

Now you can access your strings in your code using this format = `Constants.STEVE_LAST_NAME`

12. Add instructions to your README.md file to explain to others how to re-create your gradle.properties
13. Add a DataService.  Use myRestaurants as an example.
14. Add a TAG to the MainActivity `public static final String TAG = MainActivity.class.getSimpleName();`
15. Add ButterKnife to build.gradle `compile 'com.jakewharton:butterknife:8.8.1'` and `annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'`
16. Add a button to the Activity layout (use BK)







## INSTRUCTION ON HOW TO GET API ACCESS
1. First you need to get an API key
2. Then add a line to your gradle.properties file that looks like this `themoviedb_api_key=YOUR_API_KEY_HERE`
