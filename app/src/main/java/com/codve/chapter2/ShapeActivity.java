package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ShapeActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        return new Intent(context, ShapeActivity.class);
    }

    @Override
    protected Fragment createFragment() {
        return new ShapeFragment();
    }
}
