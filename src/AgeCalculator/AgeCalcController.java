package AgeCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.util.Calendar;

public class AgeCalcController {

    @FXML
    private ChoiceBox<Integer> dayCB;

    @FXML
    private ChoiceBox<Integer> yearCB;

    @FXML
    private ChoiceBox<String> monthCB;

    @FXML
    private Text resultText;

    @FXML
    private Button resultBtn;

    private String[] months = {
      "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Paździęrnik",
      "Listopad", "Grudzień"
    };



    @FXML
    void initialize(){

        for(int i=0;i<12;i++){
            monthCB.getItems().add(months[i]);
        }
        for(int i=1;i<32;i++){
            dayCB.getItems().add(i);
        }
        for(int i=2018;i>1940;i--){
            yearCB.getItems().add(i);
        }


    }

    @FXML
    void onResultBtnClicked(ActionEvent event) {

        try {
            if (!check()) {
                resultText.setText("Nie pomyliłeś się przy wprowadzaniu daty?");
            } else {


                Calendar Birthdate = Calendar.getInstance();
                Calendar Currentdate = Calendar.getInstance();

                int monthNumb = 0;

                while (!monthCB.getValue().equals(months[monthNumb])) {
                    monthNumb++;
                }

                Birthdate.set(Calendar.MONTH, monthNumb);
                Birthdate.set(Calendar.YEAR, yearCB.getValue());
                Birthdate.set(Calendar.DAY_OF_MONTH, dayCB.getValue());


                long resultTime = (Currentdate.getTimeInMillis() - Birthdate.getTimeInMillis()) / 1000L;
                resultText.setText("Od momentu twoich urodzin minęło: \n" +resultTime +" sekund!");
            }
            } catch(Exception e){
                e.printStackTrace();
                resultText.setText("Wydaje mi się, że nie wypełniłeś wszystkich pól!");
            }

        }


    private boolean check(){


            String m = monthCB.getValue();
            int d = dayCB.getValue();

            if (m.equals("Luty") && d > 29) {
                return false;
            } else if ((m.equals("Kwiecień") || m.equals("Czerwiec") || m.equals("Wrzesień") || m.equals("Listopad")) && d == 31) {
                return false;
            } else {
                return true;
            }

    }
}