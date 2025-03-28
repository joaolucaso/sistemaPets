package src.repository;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDelete {
    static Path pathCadastros = Paths.get("src/src/petCadastro");
    public void deletarArquivoAntigo(String nomeAntigoPet) {
        File file = new File(String.valueOf(pathCadastros.toAbsolutePath()));
        File[] arquivos = file.listFiles();

        String nomeFormatado = nomeAntigoPet.replaceAll("\\s", "").toUpperCase();


        for (File arquivo : arquivos) {

            if (arquivo.getName().toUpperCase().contains("-" + nomeFormatado + ".TXT")) {
                System.out.println("Arquivo encontrado: " + arquivo.getName());
                if (arquivo.delete()) {
                    System.out.println("Arquivo deletado com sucesso: " + arquivo.getName());
                } else {
                    System.out.println("Erro ao deletar: " + arquivo.getName());
                }
                return;


            }

        }
    }
}