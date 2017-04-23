package com.rafakob.androidutils.views;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class SimpleTextWatcher implements TextWatcher {
    public SimpleTextWatcher() {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        this.onTextChanged(s.toString());
    }

    public void afterTextChanged(Editable s) {
    }

    public abstract void onTextChanged(String text);
}