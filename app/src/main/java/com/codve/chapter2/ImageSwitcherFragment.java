package com.codve.chapter2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageSwitcherFragment extends Fragment {
    private ImageSwitcher mSwitcher;
    private Button mButton;
    private List<String> mImgs;
    private AssetManager mAssetManager;
    private int mPosition = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mImgs = new ArrayList<>();
        mAssetManager = getActivity().getAssets();
        String dir = "imgs";
        try {
            String[] files = mAssetManager.list(dir);
            for (String file : files) {
                mImgs.add(dir + "/" + file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_switcher, container, false);
        if (mImgs.size() == 0) {
            Toast.makeText(getActivity(), R.string.no_img_found, Toast.LENGTH_SHORT).show();
            return view;
        }
        mSwitcher = (ImageSwitcher) view.findViewById(R.id.image_switcher);
        mSwitcher.setFactory(() -> {
            ImageView imageView = new ImageView(getActivity());
            try {
                InputStream in = mAssetManager.open(mImgs.get(mPosition));
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imageView;
        });

        mButton = (Button) view.findViewById(R.id.image_switcher_button);
        mButton.setOnClickListener((view1 -> {
            mPosition = (mPosition + 1) % mImgs.size();
            InputStream in = null;
            try {
                in = mAssetManager.open(mImgs.get(mPosition));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            Drawable drawable = new BitmapDrawable(getActivity().getResources(), bitmap);
            mSwitcher.setImageDrawable(drawable);
        }));
        return view;
    }
}
