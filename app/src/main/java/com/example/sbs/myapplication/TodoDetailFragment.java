package com.example.sbs.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sbs.myapplication.databinding.FragmentTodoDetailBinding;
import com.example.sbs.myapplication.databinding.FragmentTodoListBinding;

public class TodoDetailFragment extends Fragment {
    private FragmentTodoDetailBinding binding;
    private TodoDetailFragmentArgs args;

    public TodoDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoDetailBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        args = TodoDetailFragmentArgs.fromBundle(getArguments());

        MainViewModel mainViewModel = new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(MainViewModel.class);
        int id = args.getId();

        Todo todo = mainViewModel.findTodoBydId(id);

        binding.textViewId.setText(String.valueOf(todo.getId()));
        binding.textViewTitle.setText(String.valueOf(todo.getTitle()));
    }
}
