package PasswordGenerator;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gen {

    private List<String> words;

    public Gen() {

        words = new ArrayList<>();
        for (int i = 48; i < 58; i++) {
            words.add(Character.toString((char) i));
        }
        for (int i = 65; i < 91; i++) {
            words.add(Character.toString((char) i));
        }
        for (int i = 97; i < 123; i++) {
            words.add(Character.toString((char) i));
        }


    }

    public String generatePassword(int length) {

        Random generator = new Random();

        StringBuilder password = new StringBuilder("");


        int firstNumb = generator.nextInt(2);

        if (firstNumb == 0) {
            password.append(words.get(generator.nextInt(9)));
            if (generator.nextInt(1) == 0) {
                password.append(words.get(generator.nextInt(25) + 10));
                password.append(words.get(generator.nextInt(25) + 36));
            } else  {
                password.append(words.get(generator.nextInt(25) + 36));
                password.append(words.get(generator.nextInt(25) + 10));
            }
        } else if (firstNumb == 1) {
            password.append(words.get(generator.nextInt(25) + 10));
            if (generator.nextInt(1) == 0) {
                password.append(words.get(generator.nextInt(9)));
                password.append(words.get(generator.nextInt(25) + 36));
            } else {
                password.append(words.get(generator.nextInt(25) + 36));
                password.append(words.get(generator.nextInt(9)));
            }
        } else {
            password.append(words.get(generator.nextInt(25) + 36));
            if (generator.nextInt(1) == 0) {
                password.append(words.get(generator.nextInt(9)));
                password.append(words.get(generator.nextInt(25) + 10));
            } else {
                password.append(words.get(generator.nextInt(25) + 10));
                password.append(words.get(generator.nextInt(9)));
            }
        }

        for(int i=0; i<length-3;i++){
            password.append(words.get(generator.nextInt(62)));
        }
        return (new String(password));
    }
}