package Code;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Interface.fxml"));
        stage.setTitle("Base64 Encoder/Decoder");
        stage.setScene(new Scene(fxmlLoader.load()));