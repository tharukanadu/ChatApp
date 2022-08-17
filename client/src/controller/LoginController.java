package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public AnchorPane loginAnchorPane;

    public TextField txtname;
    public PasswordField txtPassword;

    private final String one = "tharuka";
    private final String one_password = "1234";

    private final String two = "abcd";
    private final String two_password = "2468";

    private final String three = "abcd";
    private final String three_password = "1357";


    public void loginBtn(ActionEvent actionEvent) throws IOException {
      /*  if (one == txtname.toString() && one_password == txtPassword.toString()) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientOne.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }else if (two == txtname.toString() && two_password == txtPassword.toString()){
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientTwo.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }else if (three == txtname.toString() && three_password == txtPassword.toString()) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientThree.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }else {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientOne.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }*/
        if (txtname.getText().equals(one) && txtPassword.getText().
            equals(one_password)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Welcome Oshan ").show();
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientOne.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } else if (txtname.getText().equals(two) && txtPassword.getText().
                equals(two_password)) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientTwo.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();


        }else if (txtname.getText().equals(three) && txtPassword.getText().
                equals(three_password)) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ClientThree.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }

    }
}
