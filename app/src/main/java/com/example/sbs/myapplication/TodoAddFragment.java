package com.example.sbs.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sbs.myapplication.databinding.FragmentTodoAddBinding;
import com.example.sbs.myapplication.databinding.FragmentTodoListBinding;

import java.util.ArrayList;
import java.util.List;

public class TodoAddFragment extends Fragment {

    private FragmentTodoAddBinding binding;

    public TodoAddFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoAddBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel = ((MainActivity) getActivity()).viewModel;

        binding.buttonDoAdd.setOnClickListener(v -> {
            String title = binding.editTextTitle.getText().toString().trim();

            if (title.length() > 0) {
                binding.editTextTitle.setText("");
                mainViewModel.addTodoItem(title);
            }
        });
    }
}
