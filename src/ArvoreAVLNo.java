public class ArvoreAVLNo {
    private String valor;
    private int altura;
    private ArvoreAVLNo esq, dir;

    public ArvoreAVLNo(String valor) {
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

    public ArvoreAVLNo getEsq() {
        return esq;
    }

    public void setEsq(ArvoreAVLNo esq) {
        this.esq = esq;
    }

    public ArvoreAVLNo getDir() {
        return dir;
    }

    public void setDir(ArvoreAVLNo dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return String.format("[ArvoreAVLNo: valor='%s', altura=%d]", valor, altura);
    }
}
