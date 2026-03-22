public class ListaNo {
    private String valor;
    private ListaNo proximo, anterior;

    public ListaNo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
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
