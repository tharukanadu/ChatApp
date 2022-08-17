package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientTwoController implements Initializable {
    public TextField txtMessage;
    public AnchorPane loginAnchorPane;
    public TextArea textAria;
    static Socket socket = null;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;

    String messageIn = "";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket=new Socket("localhost",5000);
                    dataInputStream=new DataInputStream(socket.getInputStream());
                    dataOutputStream=new DataOutputStream(socket.getOutputStream());



                    while (!messageIn.equals("end")){
                        messageIn=dataInputStream.readUTF();
                        textAria.appendText("\nServer :"+messageIn.trim()+"\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


    public void SaveBtn(ActionEvent actionEvent) throws IOException {
        String reply = "";
        reply=txtMessage.getText();
        textAria.appendText(("\n\n\t\t\t\t\t\t\t\t\t\t\t\tTwo:" +reply.trim()));
        dataOutputStream.writeUTF(reply);
        txtMessage.setText("");
    }
}
