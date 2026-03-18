public class NoArvore {
    private String valor;
    private int altura;
    private NoArvore esq, dir;
    private String hash;

    public NoArvore(String valor) {
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

    public NoArvore getEsq() {
        return esq;
    }

    public void setEsq(NoArvore esq) {
        this.esq = esq;
    }

    public NoArvore getDir() {
        return dir;
    }

    public void setDir(NoArvore dir) {
        this.dir = dir;
    }
}
