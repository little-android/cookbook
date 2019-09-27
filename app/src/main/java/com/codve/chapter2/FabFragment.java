package com.codve.chapter2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabFragment extends Fragment {

    private FloatingActionButton mButton;
    private FloatingActionButton mButton1;
    private FloatingActionButton mButton2;
    private FloatingActionButton mButton3;
    private boolean mVisible = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab, container, false);
        mButton1 = (FloatingActionButton) view.findViewById(R.id.fab_button_1);
        mButton2 = (FloatingActionButton) view.findViewById(R.id.fab_button_2);
        mButton3 = (FloatingActionButton) view.findViewById(R.id.fab_button_3);
        mButton = (FloatingActionButton) view.findViewById(R.id.float_button);
        mButton.setOnClickListener((view1 -> {
            mVisible = !mVisible;
            if (mVisible) {
                show();
            } else {
                hide();
            }
        }));

        return view;
    }

    private void show() {
        Animation show = AnimationUtils.loadAnimation(getActivity(), R.anim.show);

        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) mButton1.getLayoutParams();
        layoutParams.bottomMargin -= (int) (mButton1.getHeight() * 3);
        mButton1.setLayoutParams(layoutParams);
        mButton1.startAnimation(show);
    }

    private void hide() {
        Animation hide = AnimationUtils.loadAnimation(getActivity(), R.anim.hide);
        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) mButton1.getLayoutParams();
        layoutParams.bottomMargin += (int) (mButton1.getHeight() * 3);
        mButton1.setLayoutParams(layoutParams);
        mButton1.startAnimation(hide);
    }

}
