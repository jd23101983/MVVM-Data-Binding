package com.deshaies.newtextwatcher;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class PasswordViewModel extends BaseObservable {

    private String password;
    private String passwordTextWatcher;
    private String passwordQuality;

    @Bindable
    public String getPasswordQuality() {
        if (password == null || password.isEmpty()) {
            return "Enter a password";
        } else if (password.equals("password")) {
            return "Very bad";
        } else if (password.length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.passwordQuality);
    }



    @Bindable
    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing.
            }
        };
    }
}