package MainWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import JapNameGen.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;


public class MainController {

    @FXML
    private Label JapGenLabel;

    @FXML
    private Label TempConvLabel;

    @FXML
    private Label AgeCalcLabel;

    @FXML
    private Label PassGenLabel;

    @FXML
    void onLabelClick(MouseEvent event) {

            String source = event.getSource().toString();


                System.out.println(event.getSource().toString());


            switch (source){

                case "Label[id=JapGenLabel, styleClass=label]'Generator Japońskich Imion'":
                    runWindow("../JapNameGen/generator_scene.fxml","Generator Japońskich Imion",452,254,false);
                    break;
                case "Label[id=TempConvLabel, styleClass=label]'Konwerter Temperatur'":
                    runWindow("../TempConverter/temperature_converter_scene.fxml","Konvwerter Temperatur",312,326,false);
                    break;
                case "Label[id=AgeCalcLabel, styleClass=label]'Kalkulator Wieku W Sekundach'":
                    runWindow("../AgeCalculator/age_calc_scene.fxml","Kalkulator Wieku W Sekundach",373,326,false);
                    break;

                case "Label[id=PassGenLabel, styleClass=label]'Generator Haseł Do Witryn'":
                    runWindow("../PasswordGenerator/password_generator_scene.fxml","Generator Haseł Do Witryn",470,246,false);
                    break;
            }
    }

    @FXML
    void onLabelPressed(MouseEvent event){
        String source = event.getSource().toString();

        switch (source){

            case "Label[id=JapGenLabel, styleClass=label]'Generator Japońskich Imion'":
              //  runWindow("../JapNameGen/generator_scene.fxml","Generator Japońskich Imion",452,254,false);
                break;
            case "Label[id=TempConvLabel, styleClass=label]'Konwerter Temperatur'":
           //     runWindow("../TempConverter/temperature_converter_scene.fxml","Konvwerter Temperatur",312,326,false);
                break;
            case "Label[id=AgeCalcLabel, styleClass=label]'Kalkulator Wieku W Sekundach'":
            //    runWindow("../AgeCalculator/age_calc_scene.fxml","Kalkulator Wieku W Sekundach",373,326,false);
                break;
        }
    }

    private void runWindow(String path, String title, int width, int height, boolean resizable){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root,width,height));
            stage.setResizable(resizable);
            stage.show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
