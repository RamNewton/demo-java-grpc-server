package com.ram.grpcdemo.server;

import com.ram.grpcdemo.service.ToDoService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ToDoServer {
    private final ToDoService toDoService;
    Server server;

    public void start() throws Exception {
        server = ServerBuilder.forPort(6666)
                .addService(toDoService)
                .build()
                .start();
    }
}
