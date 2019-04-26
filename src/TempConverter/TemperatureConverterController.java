package TempConverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TemperatureConverterController {


    @FXML
    private TextField cTextField;

    @FXML
    private Button cButton;

    @FXML
    private TextField fTextField;

    @FXML
    private Button fButton;

    @FXML
    private TextField kTextFIeld;

    @FXML
    private Button kButton;

    @FXML
    void onCButtonCLicked(ActionEvent event) {
        String value;

        if(!(  value=cTextField.getText()).equals("")){


         try {
             double numbValue = Double.parseDouble(value);
             if(numbValue>=-273.15) {
                 double kelwins, fahrenheits;
                 kelwins = numbValue + 273.15;
                 kTextFIeld.setText(kelwins + " K");

                 fahrenheits = 32 + (1.8 * numbValue);
                 fTextField.setText(fahrenheits + " °F");

                 cTextField.setText(value + " °C");
             }
         }catch (NumberFormatException e){
             e.printStackTrace();
         }
        }
    }

    @FXML
    void onFButtonClicked(ActionEvent event) {
        String value;

        if(!(  value=fTextField.getText()).equals("")){


            try {
                double numbValue = Double.parseDouble(value);
                double kelwins, celsius;

                celsius= (numbValue - 32)/(1.8);
                if(celsius>=-273.15) {
                    cTextField.setText(celsius + " °C");

                    kelwins = celsius + 273.15;
                    kTextFIeld.setText(kelwins + " K");


                    fTextField.setText(value + " °F");
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void onKButtonClicked(ActionEvent event) {
        String value;

        if(!(  value=kTextFIeld.getText()).equals("")){


            try {
                double numbValue = Double.parseDouble(value);
                if(numbValue>=0) {
                    double celsius, fahrenheits;

                    celsius = numbValue + 273.15;
                    cTextField.setText(celsius + " °C");

                    fahrenheits = 32 + (1.8 * celsius);
                    fTextField.setText(fahrenheits + " °F");

                    kTextFIeld.setText(value + " K");
                }
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void initialize(){ }

}
