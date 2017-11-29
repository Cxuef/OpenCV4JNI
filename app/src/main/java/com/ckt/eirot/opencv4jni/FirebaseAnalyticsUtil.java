package com.ckt.eirot.opencv4jni;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.HashMap;

/**
 * Created by android on 9/8/17.
 */

public class FirebaseAnalyticsUtil {
    private static final String TAG = "FirebaseAnalyticsUtil";
    private static FirebaseAnalytics mFirebaseAnalytics = OpenCV4JNIApp.getOpenCV4JNIApp().getFirebaseAnalyticsInstance();

    public static void logEvent(@NonNull String functionName, @NonNull String... params){
        Log.d(TAG, "--->>> FirebaseAnalytics logEvent");
        // [START custom_event]
        Bundle mBundleParams = new Bundle();
        for (int i = 0; i < params.length; i++) {
            mBundleParams.putString(params[i], params[i]);
        }
        mFirebaseAnalytics.logEvent(functionName, mBundleParams);
        // [END custom_event]
    }

    public static void logEvent(@NonNull String functionName, Bundle mBundleParams){
        Log.d(TAG, "--->>> FirebaseAnalytics logEvent");
        // [START custom_event]
        mFirebaseAnalytics.logEvent(functionName, mBundleParams);
        // [END custom_event]
    }


}
