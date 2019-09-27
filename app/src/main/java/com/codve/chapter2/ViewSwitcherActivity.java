package com.codve.chapter2;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class ViewSwitcherActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ViewSwitcherFragment();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ViewSwitcherActivity.class);
    }
}
