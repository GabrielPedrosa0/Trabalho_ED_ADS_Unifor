public class No {
    private String palavra;
    private No proximo, anterior;

    public No(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
