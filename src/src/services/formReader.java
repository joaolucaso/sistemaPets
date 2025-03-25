package src.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class formReader {
    public void formulario(){
    BufferedReader form;

    {
        try {
            form = new BufferedReader(new FileReader("C:\\Users\\Acer\\IdeaProjects\\desafioCadastro\\src\\docs\\formulario.txt"));
            String data ="";

            while ((data = form.readLine()) != null) {
                System.out.println(data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

}
