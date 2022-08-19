package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientOneController implements Initializable {
    public TextField txtMessage;
    public AnchorPane loginAnchorPane;
    public TextArea txtAria;
    static Socket socket = null;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    public AnchorPane txtpane;
    public TextArea textMessageArea;

private BufferedReader bufferedReader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Thread(() -> {
            try {
                socket = new Socket("localhost", 5000);
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                String record = bufferedReader.readLine();

                while (!record.equals("Exit")) {
                    record = bufferedReader.readLine();
                    textMessageArea.appendText("\nServer :" + record.trim() + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    public void saveonAction(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtMessage.getText());
        System.out.println("Client Writer :" + printWriter);
        textMessageArea.appendText("\n\n\t\t\t\t\t\t\t\tClient :" + txtMessage.getText());
        printWriter.flush();

    }

    public void imageOnAction(ActionEvent actionEvent) {

        JFileChooser jFileChooser = new JFileChooser();
        int response = jFileChooser.showOpenDialog(null);
    }
}