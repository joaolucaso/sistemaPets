package src.services;

import java.io.File;
import java.util.Scanner;
import src.docs.model.cadastroDePets;
public class menu {

public void mostrarmenu(){
            int opcao = 6;
            Scanner leitor = new Scanner(System.in);



            do {
                System.out.println("---------------------------------------------------");
                System.out.println("1- Cadastrar um novo pet |");
                System.out.println("2- Alterar os dados do pet cadastrado |");
                System.out.println("3- Deletar um pet cadastrado |");
                System.out.println("4- Listar todos os pets cadastrados |");
                System.out.println("5- Listar pets por algum critério (idade, nome, raça) |");
                System.out.println("6- sair |");
                System.out.println("---------------------------------------------------");

                System.out.print("Opção escolhida: ");
                opcao = leitor.nextShort();


                switch (opcao) {
                    case 1:
                        System.out.println("Opção de Cadastrar um novo pet");

                        break;
                    case 2:
                        System.out.println("Opção de Alterar os dados do pet cadastrado");
                        break;
                    case 3:
                        System.out.println("Opção de Deletar um pet cadastrado");
                        break;
                    case 4:
                        System.out.println("Opção de Listar todos os pets cadastrados");
                        break;
                    case 5:
                        System.out.println("Opção de Listar pets por algum critério (idade, nome, raça)");

                        break;
                    case 6:
                        System.out.println("Até logo");

                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
            }while (opcao != 6);

        }

    }

