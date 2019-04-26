package JapNameGen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GeneratorController {


    @FXML
    private Button generateButton;
    @FXML
    private Text titleLabel;

    @FXML
    private Text nameLabel;

    private Generator generator;

    @FXML
    void onGenerate(ActionEvent event) {

        titleLabel.setText("Twoje Japońskie Imię to:");
        nameLabel.setText(generator.generateName());

    }

    @FXML
    void initialize(){

        generator = new Generator();

    }


}
