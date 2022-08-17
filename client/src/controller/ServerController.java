package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    public AnchorPane anchorPlane;
    public TextArea messageArea;
    public TextField textMessage;
    Socket accept = null;
    BufferedReader bufferedReader;


    public void initialize() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(5000);
                System.out.println("Server Started..!");
                accept = serverSocket.accept();
                System.out.println("Client Connected..!");

                InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                String record = bufferedReader.readLine();

                while (!record.equals("Exit")) {
                    record = bufferedReader.readLine();
                    messageArea.appendText("\nClient :" + record.trim() + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void sendOnAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        printWriter.println(textMessage.getText());
        messageArea.appendText("\n\n\t\t\t\t\t\t\t\t\t\t\t\tServer :" + textMessage.getText());
        textMessage.setText("");
        printWriter.flush();
    }
}
