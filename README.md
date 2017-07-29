# base-android-app

Contents table
-----------------

- [Technical specifications](#technical-specifications)
- [Structure](#structure)
- [Version control](#version)
- [Libraries](#libraries)


Technical specifications
-------------

- [Android: kotlin](https://developer.android.com/kotlin/index.html)
- [Services](https://google.com)


Structure
---------------

- [MVP (Model - View - Presenter)] (https://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/)
- [Android Clean MVPContract (Model - View - Presenter + Contract)] (https://github.com/nomisRev/AndroidCleanMVP)
- [Dagger 2] (https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2)
- [RxJava2] (https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
- [RxAndroid] (https://github.com/ReactiveX/RxAndroid)


Version
---------------

       // Versions of the build
        min_sdk_version = '19'
        target_sdk_version = '25'
        build_tools_version = '25.0.2'
        compile_sdk_version = 25

        // Gradle
        gradle_version = '2.3.3'

        // Kotlin
        kotlin_version = '1.1.1'

        // Versions of dependencies
        android_support_version = '25.3.1'
        aws_sdk_version = "2.4.4"
        calligraphy_version = '2.2.0'
        crashlytics_version = '2.6.7@aar'
        dagger_version = '2.9'
        google_service_version = '3.1.0'
        joda_time_version = '2.9.4'
        play_services_version = '10.2.4'
        okhttp_version = '3.6.0'
        onesignal_version = '3.5.4@aar'
        picasso_version = '2.5.2'
        retrofit_version = '2.2.0'
        rxjava_version = '2.0.5'
        rxandroid_version = '2.0.1'
        rxbinding_version = '2.0.0'
        rxpermissions_version = '0.9.3@aar'


Libraries
---------------

```bash
dependencies {

     // ---------- Android support ----------
    compile "com.android.support:appcompat-v7:$android_support_version"
    compile "com.android.support:support-v4:$android_support_version"
    compile "com.android.support:design:$android_support_version"
    compile "com.android.support:recyclerview-v7:$android_support_version"
    compile "com.android.support:cardview-v7:$android_support_version"
    compile 'com.android.support.constraint:constraint-layout:1.0.2'

    // ---------- Google play services ----------
    compile "com.google.android.gms:play-services-gcm:$play_services_version"
    compile "com.google.android.gms:play-services-location:$play_services_version"
    compile "com.google.android.gms:play-services-maps:$play_services_version"
    compile "com.google.android.gms:play-services-auth:$play_services_version"
    compile "com.google.android.gms:play-services-analytics:$play_services_version"

    // ---------- Kotlin ----------
    compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"

    // ---------- Dagger ----------
    kapt "com.google.dagger:dagger-compiler:$dagger_version"
    compile "com.google.dagger:dagger:$dagger_version"

    // ---------- OkHttp ----------
    compile "com.squareup.okhttp3:okhttp:$okhttp_version"
    compile "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

    // ---------- Retrofit ----------
    compile "com.squareup.retrofit2:retrofit:$retrofit_version"
    compile "com.squareup.retrofit2:converter-moshi:$retrofit_version"
    compile "com.squareup.retrofit2:adapter-rxjava2:$retrofit_version"

    // ---------- Rx ----------
    compile "io.reactivex.rxjava2:rxjava:$rxjava_version"
    compile "io.reactivex.rxjava2:rxandroid:$rxandroid_version"
    compile "com.jakewharton.rxbinding2:rxbinding-kotlin:$rxbinding_version"
    compile "com.tbruyelle.rxpermissions2:rxpermissions:$rxpermissions_version"

    // ---------- Font ----------
    compile "uk.co.chrisjenx:calligraphy:$calligraphy_version"

    // ---------- For Images ----------
    compile "com.squareup.picasso:picasso:$picasso_version"

    // ---------- OpenTok ----------
    compile "com.opentok.android:opentok-accelerator-core:1.0.10"

    // ---------- OneSignal ----------
    compile "com.onesignal:OneSignal:$onesignal_version"

    // ---------- Joda-time ----------
    compile "joda-time:joda-time:$joda_time_version"

    // ---------- Aws ----------
    compile "com.amazonaws:aws-android-sdk-core:$aws_sdk_version"
    compile "com.amazonaws:aws-android-sdk-s3:$aws_sdk_version"
    compile "com.amazonaws:aws-android-sdk-ddb:$aws_sdk_version"

    // ---------- Fabric ----------
    compile('com.crashlytics.sdk.android:crashlytics:2.6.8@aar') {
        transitive = true;
    }

    // ---------- Test ----------
    androidTestCompile("com.android.support.test.espresso:espresso-core:2.2.2", {
        exclude group: "com.android.support", module: "support-annotations"
    })
    testCompile 'junit:junit:4.12'
}
