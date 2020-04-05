package com.example.sbs.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class MainViewModel extends AndroidViewModel {
    @Getter
    private List<TodoItem> todoItemList;
    @Setter
    private RecyclerViewTodoAdapter recyclerViewTodoAdapter;

    public MainViewModel(@NonNull Application application) {
        super(application);

        todoItemList = new ArrayList<>();
        todoItemList.add(new TodoItem(new Todo(1, "제목 1")));
        todoItemList.add(new TodoItem(new Todo(2, "제목 2")));
    }

    public void addTodoItem(String title) {
        int newId = 1;

        if (todoItemList.size() > 0) {
            newId = todoItemList.get(todoItemList.size() - 1).getTodo().getId() + 1;
        }
        todoItemList.add(new TodoItem(new Todo(newId, title)));
    }

    public void deleteTodoItem(TodoItem todoItem) {
        todoItemList.remove(todoItem);

        if (recyclerViewTodoAdapter != null) {
            recyclerViewTodoAdapter.notifyDataSetChanged();
        }
    }

    public Todo findTodoBydId(int id) {
        for (TodoItem todoItem : todoItemList) {
            if (todoItem.getTodo().getId() == id) {
                return todoItem.getTodo();
            }
        }

        return null;
    }
}
