package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.*;

public class Linear extends Fragment {

private LinearBinding linearBinding;
private ConstraintBinding constraintBinding;
private RelativeBinding relativeBinding;
private TableBinding tableBinding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      linearBinding = LinearBinding.inflate(inflater, container, false);
      return linearBinding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        linearBinding = null;
    }

}