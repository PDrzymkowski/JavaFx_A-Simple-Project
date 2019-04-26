package PasswordGenerator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class PassGeneratorController {

    @FXML
    private Button GenerateBtn;

    @FXML
    private Button SaveBtn;

    @FXML
    private Button ListBtn;

    @FXML
    private Text resultText;

    @FXML
    private Spinner<Integer> LengthSpinner;

    private SpinnerValueFactory<Integer> spinnerValueFactory;
    private Gen generator;
    private int whichPassword=-1;

    @FXML
    void initialize(){
        spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(4,12,4);
        LengthSpinner.setValueFactory(spinnerValueFactory);
        generator = new Gen();
    }

    @FXML
    void onGenerate(ActionEvent event) {
        try {
            resultText.setText(generator.generatePassword(LengthSpinner.getValue()));
        }catch(Exception e){
            e.printStackTrace();
            resultText.setText("Wybierz długość hasła!");
        }
    }

    @FXML
    void onSave(ActionEvent event) {


        if (resultText.getText() != "") {

        Text text = new Text("Nazwa witryny: ");
        TextField textField = new TextField();

        Dialog<String> saveDialog = new Dialog<>();
            saveDialog.setHeaderText(" Teraz podaj nazwę witryny, dla której chcesz zapamietać hasło: " + resultText.getText());
            saveDialog.setTitle("Zapisz hasło");
            saveDialog.setResizable(false);


            GridPane gridPane = new GridPane();
            gridPane.add(text,1,1);
            gridPane.add(textField,2,1);

            saveDialog.getDialogPane().setContent(gridPane);

        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            saveDialog.getDialogPane().getButtonTypes().add(buttonTypeOK);

            saveDialog.setResultConverter(new Callback<ButtonType, String>() {
                @Override
                public String call(ButtonType buttonType) {
                    if (buttonType == buttonTypeOK)
                    {
                        return textField.getText();
                    }
                     else
                        return null;
                    }
            });


        Optional<String> result = saveDialog.showAndWait();

        if(result.isPresent()){

            System.out.println(result.get());
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("./src/PasswordGenerator/results.txt", true));
                writer.append(result.get() + "\n");
                writer.append(resultText.getText() +"\n");
                writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        }
    }


    @FXML
    void onShow(ActionEvent event) {

        Dialog showDialog = new Dialog();
            showDialog.setTitle("Lista haseł do witryn");
            showDialog.setResizable(false);
        Text password = new Text("");
        Text website = new Text("");
        Button left = new Button("<-");
        Button right = new Button("->");
        ArrayList<String> results = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new FileReader("./src/PasswordGenerator/results.txt"));
            String readData;

            while( scanner.hasNext() )
            {
                readData = scanner.next();
                results.add(readData);
                System.out.println(readData);
            }
                scanner.close();

        if(results.size()>=2)
        {
            website.setText(results.get(0));
            password.setText(results.get(1));
            whichPassword = 1;
        }else whichPassword = -1;

        GridPane gridPane = new GridPane();
            gridPane.add(new Text("  Witryna"), 1, 1);
            gridPane.add(new Text("\t"), 2, 1);
            gridPane.add(new Text("  Hasło"), 3, 1);
            gridPane.add(new Text(""), 1, 2);
            gridPane.add(new Text("\t"), 2, 2);
            gridPane.add(new Text(""), 3, 2);
            gridPane.add(website, 1,3);
            gridPane.add(new Text("\t"), 2, 3);
            gridPane.add(password, 3,3);
            gridPane.add(left,1,4);
            gridPane.add(new Text("\t"), 2, 4);
            gridPane.add(right, 3, 4);


            left.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(whichPassword>1)
                    {
                        whichPassword--;
                        website.setText(results.get(2*whichPassword-2));
                        password.setText(results.get(2*whichPassword-1));
                        System.out.println(whichPassword);
                    }
                }
            });

            right.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(whichPassword<results.size()/2)
                    {

                        website.setText(results.get(2*whichPassword));
                        password.setText(results.get(2*whichPassword+1));
                        whichPassword++;
                        System.out.println(whichPassword);
                    }
                }
            });
            showDialog.getDialogPane().setContent(gridPane);


        }catch(Exception e){
            e.printStackTrace();
        }

        ButtonType buttonTypeOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            showDialog.getDialogPane().getButtonTypes().add(buttonTypeOK);

            showDialog.showAndWait();
    }

}
