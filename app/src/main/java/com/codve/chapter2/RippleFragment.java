package com.codve.chapter2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RippleFragment extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ripple, container, false);
        mTextView = (TextView) view.findViewById(R.id.ripple_text_view);
        mTextView.setOnClickListener((view1) -> {

        });

        return view;
    }
}
