package com.codve.chapter2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextViewFragment extends Fragment {

    private TextView mTextView;
    private EditText mEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_view, container, false);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        mEditText = (EditText) view.findViewById(R.id.edit_text);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mTextView.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }
}
