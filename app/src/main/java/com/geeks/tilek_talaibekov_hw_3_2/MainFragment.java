package com.geeks.tilek_talaibekov_hw_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment {
    private TextView tvZero;
    private Button btnPlusOne;
    private Button btnMinusOne;
    private Button btnNextFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        onClick();
    }



    private void initView() {
        tvZero = requireActivity().findViewById(R.id.tv_zero);
        btnPlusOne = requireActivity().findViewById(R.id.btn_plus_one);
        btnMinusOne = requireActivity().findViewById(R.id.btn_minus_one);
        btnNextFragment = requireActivity().findViewById(R.id.btn_next_fragment);
    }

    private void onClick(){
        btnPlusOne.setOnClickListener(v -> {
            operationPlus();
        });
        btnMinusOne.setOnClickListener(v -> {
            operationMinus();
        });
        btnNextFragment.setOnClickListener(v -> {
            navigateSec();
        });
    }

    private void operationPlus(){
        int value = Integer.parseInt(tvZero.getText().toString());
        if(value < 10){
            value++;
            tvZero.setText(String.valueOf(value));
        }
    }

    private void operationMinus(){
        int value = Integer.parseInt(tvZero.getText().toString());
            value--;
            tvZero.setText(String.valueOf(value));
    }
    private void navigateSec(){
        String val = tvZero.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("num", val);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, secondFragment)
                .addToBackStack(null).commit();
    }
}