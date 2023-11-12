package com.ram.grpcdemo.service;

import com.ram.grpcdemo.proto.todo.ToDoServiceGrpc;
import com.ram.grpcdemo.proto.todo.Todo;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService extends ToDoServiceGrpc.ToDoServiceImplBase {
    static List<Todo.ToDoItem> todos = new ArrayList<>();
    @Override
    public void createTodo(Todo.ToDoItem request, StreamObserver<Todo.ToDoItem> responseObserver) {
        Todo.ToDoItem newTodo = newToDo(request);
        responseObserver.onNext(newTodo);
        responseObserver.onCompleted();
        System.out.println("Created new todo " + newTodo);
    }

    synchronized private Todo.ToDoItem newToDo(Todo.ToDoItem request) {
        Todo.ToDoItem newTodo = Todo.ToDoItem.newBuilder()
                .setId(todos.size() + 1)
                .setDescription(request.getDescription())
                .build();
        todos.add(newTodo);
        return newTodo;
    }

    @Override
    public void getAllTodos(Todo.Empty request, StreamObserver<Todo.ToDoItems> responseObserver) {
        Todo.ToDoItems response = Todo.ToDoItems.newBuilder()
                        .addAllItems(todos)
                        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
