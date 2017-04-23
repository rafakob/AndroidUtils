package com.rafakob.androidutils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

public class ThemeUtils {
    @ColorInt
    public static int getColorPrimary(@NonNull final Context context) {
        return getColorFromAttr(context, R.attr.colorPrimary);
    }

    @ColorInt
    public static int getColorPrimaryDark(@NonNull final Context context) {
        return getColorFromAttr(context, R.attr.colorPrimaryDark);
    }

    @ColorInt
    public static int getColorAccent(@NonNull final Context context) {
        return getColorFromAttr(context, R.attr.colorAccent);
    }

    @ColorInt
    public static int getTextColorPrimary(@NonNull final Context context) {
        return getColorFromAttr(context, android.R.attr.textColorPrimary);
    }

    @ColorInt
    public static int getTextColorSecondary(@NonNull final Context context) {
        return getColorFromAttr(context, android.R.attr.textColorSecondary);
    }

    @DrawableRes
    public static int getSelectableItemBackground(@NonNull final Context context) {
        return getDrawableFromAttr(context, android.R.attr.selectableItemBackground);
    }

    @DrawableRes
    public static int getSelectableItemBackgroundBorderless(@NonNull final Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getDrawableFromAttr(context, android.R.attr.selectableItemBackgroundBorderless);
        } else {
            return getDrawableFromAttr(context, android.R.attr.selectableItemBackground);
        }
    }

    @ColorInt
    public static int getColorFromAttr(@NonNull final Context context, @AttrRes final int attributeColor) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeColor, value, true);
        return value.data;
    }

    @ColorInt
    public static int getColorFromRes(@NonNull final Context context, @ColorRes final int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    @DrawableRes
    public static int getDrawableFromAttr(@NonNull final Context context, @AttrRes final int attributeDrawable) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeDrawable, value, true);
        return value.resourceId;
    }
}
