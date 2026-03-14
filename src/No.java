public class No {
    private String valor;
    private int altura;
    private No esq, dir;

    public No(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}
