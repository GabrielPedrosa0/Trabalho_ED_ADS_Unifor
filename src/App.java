import java.util.List;

public class App {

    private static final String CAMINHO_ARQUIVO = "src/texto.txt";

    public static void main(String[] args) {
        System.out.println("=== Autenticador de Documentos ===\n");

        List<String> linhas = LeitorArquivo.lerArquivo(CAMINHO_ARQUIVO);

        if (linhas.isEmpty()) {
            System.out.println("Arquivo vazio ou não encontrado!");
            return;
        }

        System.out.println(">> Arquivo lido com sucesso: " + linhas.size() + " linhas encontradas\n");

        Pilha pilhaArvores = new Pilha(linhas.size());
        int numeroLinha = 0;

        for (String linha : linhas) {
            if (linha.trim().isEmpty()) {
                continue;
            }
            numeroLinha++;

            System.out.println("=== Linha " + numeroLinha + " ===");
            System.out.println("Texto original: \"" + linha + "\"");

            List<String> palavras = LeitorArquivo.extrairPalavras(linha);

            if (palavras.size() == 0) {
                System.out.println("Nenhuma palavra válida encontrada.\n");
                continue;
            }

            System.out.println("Palavras extraídas: " + String.join(", ", palavras));

            Lista lista = new Lista();
            for (String palavra : palavras) {
                lista.inserir(palavra);
            }
            System.out.println(">> Lista (ordem de leitura): " + lista);

            String[] palavrasOrdemInversa = lista.getPalavrasOrdemInversa();
            System.out.println(">> Lista (ordem inversa): [" + String.join(", ", palavrasOrdemInversa) + "]");

            ArvoreAVL arvore = new ArvoreAVL();
            for (String palavra : palavrasOrdemInversa) {
                arvore.inserirNo(palavra);
            }
            System.out.println(">> " + arvore);

            pilhaArvores.push(arvore);
            System.out.println(">> " + pilhaArvores);
            System.out.println();
        }

        System.out.println("=== Códigos de Autenticação ===\n");

        int numeroHash = 0;
        while (!pilhaArvores.isEmpty()) {
            numeroHash++;
            ArvoreAVL arvore = pilhaArvores.pop();
            String hash = arvore.getHashArvore();
            if (hash != null) {
                System.out.println("Hash " + numeroHash + ": " + hash);
            }
        }

        System.out.println("\n=== Autenticação Concluída ===");
    }
}
