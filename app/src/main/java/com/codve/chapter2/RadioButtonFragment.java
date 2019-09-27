package com.codve.chapter2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonFragment extends Fragment {

    private RadioGroup mRadioGroup;
    private RadioButton mRedRadioButton;

    private TextView mTextView;

    // 多选框
    private CheckBox mCheckBoxApple;
    private CheckBox mCheckBoxBanana;
    private CheckBox mCheckBoxOrange;
    private List<String> fruits;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fruits = new ArrayList<>();
    }

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

        mTextView = (TextView) view.findViewById(R.id.text_view_fruits);

        mCheckBoxApple = (CheckBox) view.findViewById(R.id.checkbox_apple);
        mCheckBoxBanana = (CheckBox) view.findViewById(R.id.checkbox_banana);
        mCheckBoxOrange = (CheckBox) view.findViewById(R.id.checkbox_orange);

        mCheckBoxApple.setOnCheckedChangeListener(((compoundButton, b) -> {
            String tmp = getString(R.string.checkbox_apple);
            if (b) {
                fruits.add(tmp);
            } else {
                fruits.remove(tmp);
            }
            setTextView();
        }));

        mCheckBoxBanana.setOnCheckedChangeListener(((compoundButton, b) -> {
            String tmp = getString(R.string.checkbox_banana);
            if (b) {
                fruits.add(tmp);
            } else {
                fruits.remove(tmp);
            }
            setTextView();
        }));

        mCheckBoxOrange.setOnCheckedChangeListener(((compoundButton, b) -> {
            String tmp = getString(R.string.checkbox_orange);
            if (b) {
                fruits.add(tmp);
            } else {
                fruits.remove(tmp);
            }
            setTextView();
        }));
        return view;
    }

    private void setTextView() {
        StringBuilder builder = new StringBuilder();
        builder.append("");
        String prefix = "";
        for (String fruit : fruits) {
            builder.append(prefix);
            builder.append(fruit);
            prefix = ", ";
        }
        mTextView.setText(builder.toString());
    }
}
