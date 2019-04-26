package MainWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class MainScene extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainScene.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("A Simple Project");

        primaryStage.setScene(new Scene(root,373,400));

        primaryStage.setResizable(false);
        primaryStage.show();


    }


    public static void main(String[] args) {

        launch(args);
    }

}
