package com.example.sbs.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class MainViewModel extends AndroidViewModel {
    @Getter
    private List<TodoItem> todoItemList;
    @Setter
    private RecyclerViewTodoAdapter recyclerViewTodoAdapter;
    private AppDatabase db;
    private int lastTodoId;

    public MainViewModel(@NonNull Application application) {
        super(application);

        todoItemList = new ArrayList<>();
    }

    public void addTodoItem(String title) {
        int newId = lastTodoId + 1;
        Todo todo = new Todo(newId, title);
        this.db.todoDao().add(todo);
        todoItemList.add(new TodoItem(todo));

        lastTodoId++;
    }

    public void deleteTodoItem(TodoItem todoItem) {
        this.db.todoDao().delete(todoItem.getTodo());
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

    public void setDb(AppDatabase db) {
        this.db = db;

        TodoDao todoDao = this.db.todoDao();
        List<Todo> todoList = todoDao.getAll();

        todoItemList.clear();

        for ( Todo todo : todoList ) {
            todoItemList.add(new TodoItem(todo));
            lastTodoId = todo.getId();
        }
    }
}
