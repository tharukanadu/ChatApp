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

public class ClientThreeController implements Initializable {
    public TextField txtMesssage;
    public AnchorPane loginAnchorPane;
    static Socket socket = null;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    public TextArea txtAria;

    private BufferedReader bufferedReader;
    String messageIn = "";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    socket = new Socket("localhost", 5000);
                    InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader);
                    String record = bufferedReader.readLine();

                    while (!record.equals("Exit")) {
                        record = bufferedReader.readLine();
                        txtAria.appendText("\nServer :" + record.trim() + "\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }

    public void saveButton(ActionEvent actionEvent) throws IOException {

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtMesssage.getText());
        txtAria.appendText("\n\n\t\t\t\t\t\t\t\t\t\t\t\tServer :" + txtMesssage.getText());
        printWriter.flush();
        txtMesssage.setText("");

    }

    public void LoadOnAction(ActionEvent actionEvent) {
        JFileChooser jFileChooser = new JFileChooser();
        int response = jFileChooser.showOpenDialog(null);
    }
}
