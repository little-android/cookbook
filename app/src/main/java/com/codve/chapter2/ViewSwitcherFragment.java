package com.codve.chapter2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewSwitcherFragment extends Fragment {
    private ViewSwitcher mSwitcher;
    private Button mButton;
    private LinearLayout mLayout1;
    private LinearLayout mLayout2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_switcher, container, false);

        mSwitcher = (ViewSwitcher) view.findViewById(R.id.view_switcher);
        mButton = (Button) view.findViewById(R.id.view_switcher_button);
        mLayout1 = (LinearLayout) view.findViewById(R.id.layout1);
        mLayout2 = (LinearLayout) view.findViewById(R.id.layout2);

        mButton.setOnClickListener((view1 -> {
            if (mSwitcher.getCurrentView() != mLayout1) {
                mSwitcher.showNext();
            } else {
                mSwitcher.showPrevious();
            }
        }));

        return view;
    }
}
