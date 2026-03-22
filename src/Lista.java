public class Lista {
    private ListaNo cabeca, rabo;
    private int tamanho;

    public Lista() {
        this.cabeca = null;
        this.rabo = null;
        this.tamanho = 0;
    }

    public void inserirNoFinal(String valor) {
        ListaNo novoNo = new ListaNo(valor);

        if (cabeca == null) {
            this.cabeca = novoNo;
            this.rabo = novoNo;
        } else {
            rabo.setProximo(novoNo);
            novoNo.setAnterior(rabo);
            this.rabo = novoNo;
        }
        tamanho++;
    }

    public String[] getPalavrasOrdemInversa() {
        String[] palavras = new String[tamanho];
        ListaNo atual = rabo;
        int indice = 0;

        while (atual != null) {
            palavras[indice++] = atual.getValor();
            atual = atual.getAnterior();
        }

        return palavras;
    }
}