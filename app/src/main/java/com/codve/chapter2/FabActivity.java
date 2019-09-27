package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class FabActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new FabFragment();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FabActivity.class);
    }
}
