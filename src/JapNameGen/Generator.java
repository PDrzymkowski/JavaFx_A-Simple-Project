package JapNameGen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Random;

public class Generator {




    public Generator() {



    }

    String generateName(){

        Random random = new Random();

        char lettersA[] = {'a','e','o','u','i', 'o', 'a', 'u'};
        char lettersB[] = {'b', 's', 'k', 't', 'n', 'm', 'r', 'p',  'n', 'm', 'l'};

        int numbs[] = {2,3,4,5};

        int nameLength = numbs[random.nextInt(2)];
        int surnameLength = numbs[random.nextInt(4)];

        StringBuilder name = new StringBuilder("");
        StringBuilder surname = new StringBuilder("");

        for(int i =0; i<nameLength; i++) {

            if (i == 0) {
                char ch = Character.toUpperCase(lettersB[random.nextInt(10)]);
                name.append(ch);
                name.append(lettersA[random.nextInt(7)]);
            } else {
                name.append(lettersB[random.nextInt(10)]);
                name.append(lettersA[random.nextInt(7)]);
            }
        }

        for(int n =0; n<surnameLength; n++) {

            if (n == 0) {
                char ch = Character.toUpperCase(lettersB[random.nextInt(11)]);
                surname.append(ch );
                surname.append(lettersA[random.nextInt(7)]);
            } else {
                surname.append(lettersB[random.nextInt(10)]);
                surname.append(lettersA[random.nextInt(7)]);
            }
        }




        return (name + " " + surname);
    }


}
