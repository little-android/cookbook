package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class TextViewActivity extends SingleFragmentActivity {

    public static Intent newInstance(Context context) {
        return new Intent(context, TextViewActivity.class);
    }

    @Override
    protected Fragment createFragment() {
        return new TextViewFragment();
    }
}
