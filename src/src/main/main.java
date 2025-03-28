package src.main;
import src.services.PrintMenu;
import src.docs.model.pet;
import src.repository.FileRepository;
import src.services.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        FileRepository file = new FileRepository();
        file.createFile();
        file.readFile();
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printMenuPrincipal();
        CadastrarPet cadastrarPet = new CadastrarPet();
        buscarPet buscarPet = new buscarPet();
        EditarPet editarPet = new EditarPet();
        ExcluirPet excluirPet = new ExcluirPet();
        ArrayList<pet> pets = buscarPet.buscarPet();
        do {
            if (option == 1) {
                cadastrarPet.cadastrarPet();
            }
            if (option == 2) {
                buscarPet.rodarMenuBusca();
            }
            if (option == 3) {
                excluirPet.excluirPet();
            }
            if (option == 4) {
                buscarPet.printarListaPets();
            }
            if (option == 5) {
                editarPet.editarPet(pets);
            }
            option = printMenu.printMenuPrincipal();
        } while (option != 6);
    }
}
