package com.codve.chapter2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RadioButtonFragment extends Fragment {

    private RadioGroup mRadioGroup;
    private RadioButton mRedRadioButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radio_button, container, false);
        mRadioGroup = view.findViewById(R.id.radio_group);
        mRadioGroup.setOnCheckedChangeListener(((radioGroup, id) -> {
            if (id == R.id.radio_button_red) {
                view.setBackgroundColor(getResources().getColor(R.color.light_red));
            } else {
                view.setBackgroundColor(getResources().getColor(R.color.light_blue));
            }
        }));

        // 获取单选按钮组默认选中的 id
        int id = mRadioGroup.getCheckedRadioButtonId();
        Log.i("radioGroup", String.valueOf(id));

        mRedRadioButton = (RadioButton) view.findViewById(R.id.radio_button_red);

        // 获取单选按钮的状态
        boolean status = mRedRadioButton.isChecked();
        Log.i("radio", String.valueOf(status));


        return view;
    }
}
