public class NoLista {
    private String valor;
    private NoLista proximo, anterior;

    public NoLista(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public NoLista getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLista anterior) {
        this.anterior = anterior;
    }

    public NoLista getProximo() {
        return proximo;
    }

    public void setProximo(NoLista proximo) {
        this.proximo = proximo;
    }
}
