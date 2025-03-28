package src.repository;
import  src.docs.model.pet;
import src.services.buscarPet;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileRepository {
//Esta classe é responsável por manipular arquivos relacionados ao cadastro de pets, incluindo a criação de formulários,
// leitura de dados e salvamento de informações.

    static Path pathForm = Paths.get("src/src/docs/formulario.txt");
    static Path pathCadastrar = Paths.get("src/src/petCadastro");

    public void createFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet (Cachorro/Gato)\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readSpecifyLineFile(int line) {
        File file = new File(String.valueOf(pathForm.toAbsolutePath()));
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            int cont = 1;
            while ((linha = br.readLine()) != null) {
                if (cont == line) {
                    System.out.println(linha);
                    return linha;
                }
                cont++;
            }
            return linha;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePetFile(pet Pet) {
        String nomeFormatado = Pet.getPetName().replace(" ", "").toUpperCase();
        buscarPet buscarPet = new buscarPet();
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = agora.format(formatter);

        String nomeArquivo = dataHoraFormatada + "-" + nomeFormatado + ".txt";

        File diretorio = new File(String.valueOf(pathCadastrar.toAbsolutePath()));
        File arquivo = new File(diretorio, nomeArquivo);
        if (!diretorio.exists()) {
            if (diretorio.mkdirs()) {
                System.out.println("Diretório criado com sucesso");
            } else {
                System.out.println("Falha ao criar diretório.");
            }

        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write("1 - " + Pet.getPetName());
            bw.newLine();
            bw.write("2 - " + Pet.getPetType());
            bw.newLine();
            bw.write("3 - " + Pet.getPetGender());
            bw.newLine();
            bw.write("4 - " + Pet.getAddress().getStreet() + ", " + Pet.getAddress().getHouseNumber() + ", " + Pet.getAddress().getCity());
            bw.newLine();
            bw.write("5 - " + Pet.getPetAge() + " anos");
            bw.newLine();
            bw.write("6 - " + Pet.getPetWeight() + "kg");
            bw.newLine();
            bw.write("7 - " + Pet.getPetBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: " + e.getMessage());
        }

        System.out.println("Pet salvo! Atualizando lista de pets...");
        buscarPet.buscarPet();
    }

    }

