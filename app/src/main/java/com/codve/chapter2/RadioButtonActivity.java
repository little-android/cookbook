package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class RadioButtonActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, RadioButtonActivity.class);
    }

    @Override
    protected Fragment createFragment() {
        return new RadioButtonFragment();
    }
}
