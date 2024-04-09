document.addEventListener("DOMContentLoaded", function() {
    var userName = prompt("What Is Your Name");

    var chatPage = document.getElementById("chatpage");

    var userHeader = document.getElementById("user");

    var chatMessage = document.getElementById("chatmessage");

    var sendMessage =  document.getElementById("sendmessage");

    userHeader.innerHTML = `Hello ${userName}`;

    let myWebSocket = new WebSocket("ws://localhost:8100");
    console.log(myWebSocket);

    myWebSocket.onopen = function() {
        console.log("Connection Open");

        data_to_send = {
            userName: userName,
            type: "login"
        };

        data = JSON.stringify(data_to_send);
        this.send(data);
    };

    myWebSocket.onerror = function() {
        console.log("Error Connection Sorry");
    };

    myWebSocket.onmessage = function(event) {
        console.log("message received");
        console.log(event.data, typeof data);
        message = JSON.parse(event.data);
        chatPage.innerHTML += message['content']
    };

    sendMessage.addEventListener("click", function() {
        myMessage = chatMessage.value;
        chatMessage.value = '';

        console.log(myMessage);

        msobj = {
            type: "chat",
            "userName": userName,
            body: myMessage + "\n"
        };

        msobj = JSON.stringify(msobj);
        myWebSocket.send(msobj);
    });
});
