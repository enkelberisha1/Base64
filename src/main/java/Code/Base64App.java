package Code;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;
public class Base64App extends Application {
        @Override
        public void start(Stage stage) throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Interface.fxml"));
                stage.setTitle("Base64 Encoder/Decoder");
                stage.setScene(new Scene(fxmlLoader.load()));


        }

}