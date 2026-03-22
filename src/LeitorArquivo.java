import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

    public static List<String> lerArquivo(String caminhoArquivo) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return linhas;
    }

    public static List<String> extrairPalavras(String linha) {
        List<String> palavrasLimpas = new ArrayList<>();
        String[] palavras = linha.split("\\s+");

        for (String palavra : palavras) {
            String textoLimpo = palavra.replaceAll("^[^a-zA-Z0-9À-ÿ]+|[^a-zA-Z0-9À-ÿ]+$", "");
            if (!textoLimpo.isEmpty()) {
                palavrasLimpas.add(textoLimpo);
            }
        }

        return palavrasLimpas;
    }
}