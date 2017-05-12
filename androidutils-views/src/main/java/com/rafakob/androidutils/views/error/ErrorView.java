package com.rafakob.androidutils.views.error;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rafakob.androidutils.R;


public class ErrorView extends LinearLayout {
    private ImageView icon;
    private TextView message;
    private Button action;

    public ErrorView(Context context) {
        super(context);
        setup(null);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(attrs);
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(attrs);
    }

    private void setup(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_error, this);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        icon = (ImageView) findViewById(R.id.icon);
        message = (TextView) findViewById(R.id.message);
        action = (Button) findViewById(R.id.action);

        if (attrs == null) {
            return;
        }

        TypedArray ta = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ErrorView, 0, 0);

        if (ta.hasValue(R.styleable.ErrorView_error_message)) {
            setMessage(ta.getString(R.styleable.ErrorView_error_message));
        }
        if (ta.hasValue(R.styleable.ErrorView_error_message_color)) {
            message.setTextColor(ta.getColor(R.styleable.ErrorView_error_message_color, 0));
        }
        if (ta.hasValue(R.styleable.ErrorView_error_action)) {
            setAction(ta.getString(R.styleable.ErrorView_error_action));
        }
        if (ta.hasValue(R.styleable.ErrorView_error_icon)) {
            setIcon(ta.getDrawable(R.styleable.ErrorView_error_icon));
        }
        if (ta.hasValue(R.styleable.ErrorView_error_icon_tint)) {
            icon.setColorFilter(ta.getColor(R.styleable.ErrorView_error_icon_tint, 0), PorterDuff.Mode.SRC_IN);
        }

        ta.recycle();
    }

    public void setIcon(@DrawableRes int iconRes) {
        this.icon.setImageResource(iconRes);
        this.icon.setVisibility(iconRes == 0 ? GONE : VISIBLE);
    }

    public void setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
        this.icon.setVisibility(drawable == null ? GONE : VISIBLE);
    }

    public void setMessage(String messageView) {
        this.message.setText(messageView);
    }

    public void setMessage(@StringRes int message) {
        this.message.setText(message);
    }

    public void setAction(String action) {
        this.action.setText(action);
        this.action.setVisibility(TextUtils.isEmpty(action) ? GONE : VISIBLE);
    }

    public void setAction(@StringRes int action) {
        setAction(getResources().getString(action));
    }

    public void setListener(final ErrorListener errorListener) {
        if (errorListener != null) {
            action.setVisibility(VISIBLE);
            action.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    errorListener.onErrorActionClick();
                }
            });
        } else {
            action.setVisibility(GONE);
        }
    }
}
