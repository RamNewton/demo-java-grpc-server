const grpc = require("@grpc/grpc-js");
const protoLoader = require('@grpc/proto-loader');
const toDoDefinition = protoLoader.loadSync("/Users/ra3/Ram/sandbox/grpcdemo/src/main/proto/todo.proto", {});
const toDoObject = grpc.loadPackageDefinition(toDoDefinition);
const client = new toDoObject.todo.ToDoService("localhost:6666", grpc.credentials.createInsecure());
const arg = process.argv[2];

for (let i = 0; i < 4; i++) {
    client.CreateTodo(
        {
            "id": -1,
            "description": `item ${i}`
        },
        (err, response) => {}
    )
}