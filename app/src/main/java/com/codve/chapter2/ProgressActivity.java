package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ProgressActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ProgressFragment();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ProgressActivity.class);
    }
}
