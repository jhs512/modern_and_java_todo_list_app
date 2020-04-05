package com.example.sbs.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sbs.myapplication.databinding.FragmentTodoListBinding;

import java.util.List;

public class TodoListFragment extends Fragment {
    private FragmentTodoListBinding binding;

    public TodoListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoListBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainViewModel mainViewModel = ((MainActivity) getActivity()).viewModel;
        List<TodoItem> todoItemList = mainViewModel.getTodoItemList();

        RecyclerViewTodoAdapter recyclerViewTodoAdapter = new RecyclerViewTodoAdapter(mainViewModel, todoItemList);

        binding.recyclerViewTodo.setAdapter(recyclerViewTodoAdapter);

        mainViewModel.setRecyclerViewTodoAdapter(recyclerViewTodoAdapter);
    }
}
