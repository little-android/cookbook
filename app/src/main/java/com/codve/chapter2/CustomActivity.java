package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class CustomActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CustomActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CustomFragment();
    }
}
