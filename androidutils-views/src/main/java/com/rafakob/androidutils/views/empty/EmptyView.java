package com.rafakob.androidutils.views.empty;

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


public class EmptyView extends LinearLayout {
    private ImageView icon;
    private TextView message;
    private Button action;

    public EmptyView(Context context) {
        super(context);
        setup(null);
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(attrs);
    }

    public EmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(attrs);
    }

    private void setup(AttributeSet attrs) {
        inflate(getContext(), R.layout.view_empty, this);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        icon = (ImageView) findViewById(R.id.icon);
        message = (TextView) findViewById(R.id.message);
        action = (Button) findViewById(R.id.action);

        if (attrs == null) {
            return;
        }

        TypedArray ta = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.EmptyView, 0, 0);

        if (ta.hasValue(R.styleable.EmptyView_empty_message)) {
            setMessage(ta.getString(R.styleable.EmptyView_empty_message));
        }
        if (ta.hasValue(R.styleable.EmptyView_empty_message_color)) {
            message.setTextColor(ta.getColor(R.styleable.EmptyView_empty_message_color, 0));
        }
        if (ta.hasValue(R.styleable.EmptyView_empty_action)) {
            setAction(ta.getString(R.styleable.EmptyView_empty_action));
        }
        if (ta.hasValue(R.styleable.EmptyView_empty_icon)) {
            setIcon(ta.getDrawable(R.styleable.EmptyView_empty_icon));
        }
        if (ta.hasValue(R.styleable.EmptyView_empty_icon_tint)) {
            icon.setColorFilter(ta.getColor(R.styleable.EmptyView_empty_icon_tint, 0), PorterDuff.Mode.SRC_IN);
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

    public void setListener(final EmptyListener emptyListener) {
        if (emptyListener != null) {
            action.setVisibility(VISIBLE);
            action.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    emptyListener.onEmptyActionClick();
                }
            });
        } else {
            action.setVisibility(GONE);
        }
    }
}
