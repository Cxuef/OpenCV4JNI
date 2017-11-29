package com.ckt.eirot.opencv4jni;

import android.app.Application;
import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by android on 9/8/17.
 */

public class OpenCV4JNIApp extends Application {
    private static OpenCV4JNIApp mOpenCV4JNIApp;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void setOpenCV4JNIApp(OpenCV4JNIApp mApplication) {
        mOpenCV4JNIApp = mApplication;
    }

    public static OpenCV4JNIApp getOpenCV4JNIApp() {
        return mOpenCV4JNIApp;
    }

    public FirebaseAnalytics getFirebaseAnalyticsInstance() {
        if (mFirebaseAnalytics == null) {
            return FirebaseAnalytics.getInstance(this);
        }
        return mFirebaseAnalytics;
    }
}
