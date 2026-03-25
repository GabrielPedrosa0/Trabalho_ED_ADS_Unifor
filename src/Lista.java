public class Lista {
    private No head, tail;
    private int tamanho;

    public Lista() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public void inserir(String palavra) {
        No novoNo = new No(palavra);

        if (head == null) {
            this.head = novoNo;
            this.tail = novoNo;
        } else {
            tail.setProximo(novoNo);
            novoNo.setAnterior(tail);
            this.tail = novoNo;
        }
        tamanho++;
    }

    public String[] getPalavrasOrdemInversa() {
        String[] palavras = new String[tamanho];
        No atual = tail;
        int indice = 0;

        while (atual != null) {
            palavras[indice++] = atual.getPalavra();
            atual = atual.getAnterior();
        }

        return palavras;
    }

    // public void inserirNaAVL(ArvoreAVL avl){
    //     No atual = tail;

    //     while(atual != null){
    //         avl.inserirNo(atual.getPalavra());
    //         atual = atual.getAnterior();
    //     }
    // }
}