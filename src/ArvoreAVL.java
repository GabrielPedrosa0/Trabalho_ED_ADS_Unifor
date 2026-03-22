public class ArvoreAVL {
    ArvoreAVLNo raiz;
    int tamanho;

    public ArvoreAVL() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void inserirNo(String valor) {
        this.raiz = insercaoRecursiva(this.raiz, valor);
    }

    public String getHashArvore() {
        if (this.raiz == null)
            return null;
        return gerarHashArvore(this.raiz);
    }

    private ArvoreAVLNo insercaoRecursiva(ArvoreAVLNo atual, String valor) {
        if (atual == null) {
            ArvoreAVLNo novo = new ArvoreAVLNo(valor);
            novo.setAltura(1);
            return novo;
        }

        if (valor.compareToIgnoreCase(atual.getValor()) == 0) {
            return atual;
        }

        if (valor.compareToIgnoreCase(atual.getValor()) < 0) {
            atual.setEsq(insercaoRecursiva(atual.getEsq(), valor));
        } else {
            atual.setDir(insercaoRecursiva(atual.getDir(), valor));
        }

        atual.setAltura(calcularAltura(atual));

        int balanceamento = altura(atual.getEsq()) - altura(atual.getDir());
        if (balanceamento > 1) {
            if (altura(atual.getEsq().getEsq()) < altura(atual.getEsq().getDir())) {
                // rodar esquerda
                rotacaoEsquerda(atual.getEsq());
            }
            // rodar direita
            rotacaoDireita(atual);

        } else if (balanceamento < -1) {
            if (altura(atual.getDir().getDir()) < altura(atual.getDir().getEsq())) {
                // rodar direita
                rotacaoDireita(atual.getDir());
            }
            // rodar esquerda
            rotacaoEsquerda(atual);
        }
        return atual;

    }

    private int altura(ArvoreAVLNo no) {
        return no == null ? 0 : no.getAltura();
    }

    private int calcularAltura(ArvoreAVLNo no) {
        return Math.max(altura(no.getEsq()), altura(no.getDir())) + 1;
    }

    private ArvoreAVLNo rotacaoDireita(ArvoreAVLNo antigaRaiz) {
        ArvoreAVLNo novaRaiz = antigaRaiz.getEsq();
        antigaRaiz.setEsq(novaRaiz.getDir());
        novaRaiz.setDir(antigaRaiz);
        antigaRaiz.setAltura(calcularAltura(antigaRaiz));
        novaRaiz.setAltura(calcularAltura(novaRaiz));
        return novaRaiz;
    }

    private ArvoreAVLNo rotacaoEsquerda(ArvoreAVLNo antigaRaiz) {
        ArvoreAVLNo novaRaiz = antigaRaiz.getDir();
        antigaRaiz.setDir(novaRaiz.getEsq());
        novaRaiz.setEsq(antigaRaiz);
        antigaRaiz.setAltura(calcularAltura(antigaRaiz));
        novaRaiz.setAltura(calcularAltura(novaRaiz));
        return novaRaiz;
    }

    private String gerarHashArvore(ArvoreAVLNo no) {
        if (no == null)
            return "";

        String hashEsq = gerarHashArvore(no.getEsq());
        String hashDir = gerarHashArvore(no.getDir());

        try {
            return HasheadorString.sha1(hashEsq + hashDir + no.getValor());
        } catch (Exception e) {
            return "";
        }
    }
}
