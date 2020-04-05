package com.example.sbs.myapplication;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sbs.myapplication.databinding.ItemTodoBinding;

import java.util.List;

public class RecyclerViewTodoAdapter extends RecyclerView.Adapter<RecyclerViewTodoAdapter.ViewHolder> {
    private MainViewModel mainViewModel;
    private List<TodoItem> todoItemList;

    public RecyclerViewTodoAdapter(MainViewModel mainViewModel, List<TodoItem> todoItemList) {
        this.mainViewModel = mainViewModel;
        this.todoItemList = todoItemList;
    }

    @NonNull
    @Override
    public RecyclerViewTodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTodoBinding binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.setMainViewModel(mainViewModel);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTodoAdapter.ViewHolder holder, int position) {
        TodoItem todoItem = todoItemList.get(position);
        holder.binding.setItem(todoItem);
    }

    @Override
    public int getItemCount() {
        return todoItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemTodoBinding binding;

        public ViewHolder(@NonNull ItemTodoBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
