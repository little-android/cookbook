package com.codve.chapter2;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private Button mViewPhotoButton; // 浏览图片按钮
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewPhotoButton = view.findViewById(R.id.photo_view_button);
        mViewPhotoButton.setOnClickListener((view1) -> {
            startActivity(ViewPhotoActivity.newIntent(getActivity()));
        });
        return view;
    }
}
