package src.services;

import src.docs.model.pet;
import src.docs.model.PetGender;
import src.docs.model.PetType;
import src.docs.model.PetAddress;
import src.utils.ValidatorUtils;
import src.repository.FileRepository;

import java.util.Scanner;

public class CadastrarPet {

    public void cadastrarPet() {
        Scanner input = new Scanner(System.in);
        pet Pet = new pet();
        FileRepository fileRepository = new FileRepository();
        PetAddress petAddress = new PetAddress();
        ValidatorUtils validatorUtils = new ValidatorUtils();

        // PERGUNTA 1 - NOME E SOBRENOME
        FileRepository.readSpecifyLineFile(1);
        Pet.setPetName(validatorUtils.lerNomeValido(input));

        // PERGUNTA 2 - TIPO ANIMAL
        FileRepository.readSpecifyLineFile(2);
        System.out.println("1 = Cachorro | 2 = Gato");
        Pet.setPetTypeChoose(validatorUtils.lerUmOuDoisValido(input));

        // PERGUNTA 3 - GENERO ANIMAL
        FileRepository.readSpecifyLineFile(3);
        System.out.println("1 = Macho | 2 = Fêmea");
        Pet.setPetGenderChoose(validatorUtils.lerUmOuDoisValido(input));


        // PERGUNTA 4 - ENDEREÇO ENCONTRADO
        FileRepository.readSpecifyLineFile(4);
        System.out.println("Número da casa: ");
        petAddress.setHouseNumber(validatorUtils.lerNValido(input));

        System.out.println("Cidade: ");
        petAddress.setCity(input.nextLine());

        System.out.println("Rua: ");
        petAddress.setStreet(input.nextLine());


        // PERGUNTA 5 - IDADE APROXIAMDA
        FileRepository.readSpecifyLineFile(5);
        Pet.setPetAge(validatorUtils.lerIdadeValido(input));


        // PERGUNTA 6 - PESO
        FileRepository.readSpecifyLineFile(6);
        Pet.setPetWeight(validatorUtils.lerPesoValido(input));


        // PERGUNTA 7 - RAÇA
        FileRepository.readSpecifyLineFile(7);
        input.nextLine();
        Pet.setPetBreed(input.nextLine());


        Pet.setAddress(petAddress);
        fileRepository.savePetFile(Pet);

    }


}
