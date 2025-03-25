package src.main;

import src.services.formReader;
import src.services.menu;


public class main {
    public static void main(String[] args) {

        formReader PrintForm = new formReader();
        PrintForm.formulario();

        menu menu = new menu();
        menu.mostrarmenu();


    }
}
