import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("texto.txt");
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println("Linha: " + linha);

                String[] palavras = linha.split("\\s+");

                for (String palavra : palavras) {
                    String textoLimpo = palavra.replaceAll("\\P{L}", "");

                    if (!textoLimpo.isEmpty()) {    
                        System.out.println("Palavra: " + textoLimpo);
                        
                    }
                }
            }
            br.close(); 
            fr.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}