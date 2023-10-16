package com.example.ismailov_argen_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    private Button plusOne;
    private TextView Zero;
    private int count = 0;
    private Button min;
    private Button result;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initListener();
        goTonextFragment();

    }

    private void initView() {
        plusOne = requireActivity().findViewById(R.id.plus_one);
        Zero = requireActivity().findViewById(R.id.zero);
        min = requireActivity().findViewById(R.id.min);
        result = requireActivity().findViewById(R.id.resultat);
    }

    private void initListener() {
        plusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.plus_one) {
                    count++;
                    Zero.setText(String.valueOf(count));
                }

            }

        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.min){
                    count--;
                    Zero.setText(String.valueOf(count));
                }
            }
        });
    }
    private void goTonextFragment(){
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("123", count);
                Result result= new Result();
                result.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_container,result).addToBackStack(null).commit();

            }
        });

    }

}



