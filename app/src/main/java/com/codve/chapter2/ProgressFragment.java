package com.codve.chapter2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProgressFragment extends Fragment {

    private ProgressBar mBar;
    private ProgressBar mCustomBar; // 自定义的进度条

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_progress_bar, container, false);
        mBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        mCustomBar = (ProgressBar) view.findViewById(R.id.progress_bar_custom);
        new Worker().execute();
        return view;
    }

    private class Worker extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mBar.setProgress(values[0]);
            mCustomBar.setProgress(values[0]);
        }
    }
}
