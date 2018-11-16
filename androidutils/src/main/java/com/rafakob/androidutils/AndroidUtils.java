package com.rafakob.androidutils;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.appcompat.app.AppCompatActivity;

public class AndroidUtils {

    public static AppCompatActivity getActivityFromContext(Context context) {
        if (context == null) {
            return null;
        } else if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        } else if (context instanceof ContextWrapper) {
            return getActivityFromContext(((ContextWrapper) context).getBaseContext());
        } else {
            return null;
        }
    }

    public static String getStringResByName(Context context, String resName) {
        final int resId = context.getResources().getIdentifier(resName, "string", context.getPackageName());
        return context.getString(resId);
    }

    public static String getStringResByName(Context context, String resName, String[] formatArgs) {
        final int resId = context.getResources().getIdentifier(resName, "string", context.getPackageName());
        return context.getString(resId, formatArgs);
    }
}
