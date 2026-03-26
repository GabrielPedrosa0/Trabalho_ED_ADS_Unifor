public class Lista {
    private ListaNo cabeca, cauda;
    private int tamanho;

    public Lista() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void inserir(String valor) {
        ListaNo novoNo = new ListaNo(valor);

        if (cabeca == null) {
            this.cabeca = novoNo;
            this.cauda = novoNo;
        } else {
            cauda.setProximo(novoNo);
            novoNo.setAnterior(cauda);
            this.cauda = novoNo;
        }
        tamanho++;
    }

    public String[] getPalavrasOrdemInversa() {
        String[] palavras = new String[tamanho];
        ListaNo atual = cauda;
        int indice = 0;

        while (atual != null) {
            palavras[indice++] = atual.getPalavra();
            atual = atual.getAnterior();
        }

        return palavras;
    }
}