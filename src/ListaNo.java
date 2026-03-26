public class ListaNo {
    private String palavra;
    private ListaNo proximo, anterior;

    public ListaNo(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public ListaNo getAnterior() {
        return anterior;
    }

    public void setAnterior(ListaNo anterior) {
        this.anterior = anterior;
    }

    public ListaNo getProximo() {
        return proximo;
    }

    public void setProximo(ListaNo proximo) {
        this.proximo = proximo;
    }
}
