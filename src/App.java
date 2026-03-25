import java.util.List;

public class App {

    private static final String CAMINHO_ARQUIVO = "src/texto.txt";

    public static void main(String[] args) {

        List<String> linhas = LeitorArquivo.lerArquivo(CAMINHO_ARQUIVO);

        if (linhas.isEmpty()) {
            System.out.println("Arquivo vazio ou não encontrado!");
            return;
        }

        Pilha pilhaArvores = new Pilha(linhas.size());

        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue;
            }

            List<String> palavras = LeitorArquivo.extrairPalavras(linha);

            if (palavras.size() == 0) {
                System.out.println("Nenhuma palavra válida encontrada.\n");
                continue;
            }

            Lista lista = new Lista();
            for (String palavra : palavras) {
                lista.inserirNoFinal(palavra);
            }

            String[] palavrasOrdemInversa = lista.getPalavrasOrdemInversa();

            ArvoreAVL arvore = new ArvoreAVL();
            for (String palavra : palavrasOrdemInversa) {
                arvore.inserirNo(palavra);
            }

            pilhaArvores.push(arvore);
        }

        while (!pilhaArvores.isEmpty()) {
            ArvoreAVL arvore = pilhaArvores.pop();
            String hash = arvore.getHashArvore();
            if (hash != null) {
                System.out.println(hash);
            }
        }
    }
}
