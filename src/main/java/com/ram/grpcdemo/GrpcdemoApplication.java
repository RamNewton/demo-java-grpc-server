package com.ram.grpcdemo;

import com.ram.grpcdemo.server.ToDoServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GrpcdemoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(GrpcdemoApplication.class, args);
        context.getBean("toDoServer", ToDoServer.class).start();
    }

}
