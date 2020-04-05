package com.example.sbs.myapplication;

import android.view.View;

import androidx.navigation.Navigation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    private Todo todo;

    public void goToDetail(View v) {
        TodoListFragmentDirections.ActionTodoListFragmentToTodoDetailFragment actionTodoListFragmentToTodoDetailFragment = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailFragment(todo.getId());
        Navigation.findNavController(v).navigate(actionTodoListFragmentToTodoDetailFragment);
    }
}
