package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ToggleActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, ToggleActivity.class);
    }

    @Override
    protected Fragment createFragment() {
        return new ToggleFragment();
    }
}
