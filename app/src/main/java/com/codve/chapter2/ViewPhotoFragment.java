package com.codve.chapter2;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ViewPhotoFragment extends Fragment {

    private ImageView mImageView;
    private AssetManager mAssetManager;
    private List<String> mImgs;
    private int mIndex;
    private String dir;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImgs = new ArrayList<>();
        mIndex = 0;
        dir = "imgs";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_photo, container, false);
        mImageView = view.findViewById(R.id.image_view);

        mAssetManager = getContext().getAssets();
        try {
            String[] imgs = mAssetManager.list(dir);
            for (String img : imgs) {
                mImgs.add(dir + "/" + img);
            }
        } catch (IOException e) {
            throwMessage(e);
        }

        updateImg();

        mImageView.setOnClickListener((view1) -> {
            mIndex = (mIndex + 1) % mImgs.size();
            updateImg();
        });
        return view;
    }

    private void throwMessage(Exception e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void updateImg() {
        if (mImgs.size() == 0) {
            throwMessage(new Exception(getString(R.string.no_img_found)));
            return;
        }
        try {
            InputStream in = mAssetManager.open(mImgs.get(mIndex));
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            mImageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            throwMessage(e);
        }
    }
}
