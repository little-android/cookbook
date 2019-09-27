package com.codve.chapter2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ToggleFragment extends Fragment {
    private ToggleButton mToggleButton;
    private Switch mSwitch;
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toggle, container, false);

        mToggleButton = (ToggleButton) view.findViewById(R.id.toggle_button);
        mToggleButton.setOnCheckedChangeListener(((compoundButton, b) -> {
            setBackground(view, b);
        }));

        mTextView = (TextView) view.findViewById(R.id.switch_title);
        mTextView.setText(R.string.toggle_button_on_title);

        mSwitch = (Switch) view.findViewById(R.id.switch_button);
        mSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            setBackground(view, b);
            setTextView(view, b);
        });

        return view;
    }

    private void setBackground(View view, boolean b) {
        if (b) {
            view.setBackgroundColor(getResources().getColor(R.color.light_red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.light_blue));
        }
    }

    private void setTextView(View view, boolean b) {
        if (b) {
            mTextView.setText(R.string.toggle_button_off_title);
        } else {
            mTextView.setText(R.string.toggle_button_on_title);
        }
    }
}
