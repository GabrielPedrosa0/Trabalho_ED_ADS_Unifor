public class Lista {
    private ListaNo cabeca, rabo;
    private int tamanho;

    public Lista() {
        this.cabeca = null;
        this.rabo = null;
        this.tamanho = 0;
    }

    public void inserir(String valor) {
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
            palavras[indice++] = atual.getPalavra();
            atual = atual.getAnterior();
        }

        return palavras;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (cabeca == null) {
            return "Lista: []";
        }

        StringBuilder sb = new StringBuilder("Lista: [");
        ListaNo atual = cabeca;
        while (atual != null) {
            sb.append("'").append(atual.getValor()).append("'");
            if (atual.getProximo() != null) {
                sb.append(", ");
            }
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}