package com.codve.chapter2;

import android.app.Activity;
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
    private Button mDrawButton; // 绘制自定义视图
    private Button mTextEditButton; // 编辑文本按钮
    private Button mRippleButton; // 水印测试按钮
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Activity activity = getActivity();
        mViewPhotoButton = (Button) view.findViewById(R.id.photo_view_button);
        mViewPhotoButton.setOnClickListener((view1) -> {
            startActivity(ViewPhotoActivity.newIntent(activity));
        });

        mDrawButton = (Button) view.findViewById(R.id.custom_view);
        mDrawButton.setOnClickListener(view1 -> {
            startActivity(CustomActivity.newIntent(activity));
        });

        mTextEditButton = (Button) view.findViewById(R.id.text_edit_button);
        mTextEditButton.setOnClickListener((view1 -> {
            startActivity(TextViewActivity.newIntent(activity));
        }));

        mRippleButton = (Button) view.findViewById(R.id.custom_ripple);
        mRippleButton.setOnClickListener((view1 -> {
            startActivity(RippleActivity.newIntent(activity));
        }));

        return view;
    }
}
