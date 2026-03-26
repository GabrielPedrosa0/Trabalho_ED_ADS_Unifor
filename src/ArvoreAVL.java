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

        String hash = gerarHashArvore(this.raiz);
        return hash != null ? hash : "";
    }

    private ArvoreAVLNo insercaoRecursiva(ArvoreAVLNo atual, String valor) {
        if (atual == null) {
            ArvoreAVLNo novo = new ArvoreAVLNo(valor);
            novo.setAltura(1);
            tamanho++;
            return novo;
        }

        int cmp = valor.compareToIgnoreCase(atual.getValor());
        if (cmp == 0) {
            return atual;
        }

        if (cmp < 0) {
            atual.setEsq(insercaoRecursiva(atual.getEsq(), valor));
        } else {
            atual.setDir(insercaoRecursiva(atual.getDir(), valor));
        }

        atual.setAltura(calcularAltura(atual));

        int balanceamento = altura(atual.getEsq()) - altura(atual.getDir());

        if (balanceamento > 1) {
            if (altura(atual.getEsq().getDir()) > altura(atual.getEsq().getEsq())) {
                atual.setEsq(rotacaoEsquerda(atual.getEsq()));
            }
            atual = rotacaoDireita(atual);
        } else if (balanceamento < -1) {
            if (altura(atual.getDir().getEsq()) > altura(atual.getDir().getDir())) {
                atual.setDir(rotacaoDireita(atual.getDir()));
            }
            atual = rotacaoEsquerda(atual);
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
            return null;

        String hashEsq = gerarHashArvore(no.getEsq());
        String hashDir = gerarHashArvore(no.getDir());

        String combinado = "";
        if (hashEsq != null)
            combinado += hashEsq;
        if (hashDir != null)
            combinado += hashDir;

        try {
            String hashAtual = HasheadorString.sha1(no.getValor());
            if (combinado != "") {
                combinado += hashAtual;
                return HasheadorString.sha1(combinado);
            }
            return hashAtual;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "ArvoreAVL: [vazia]";
        }
        return "ArvoreAVL: [raiz=" + raiz.getValor() + ", tamanho=" + tamanho + ", estrutura=" + imprimirArvore(raiz, 0)
                + "]";
    }

    private String imprimirArvore(ArvoreAVLNo no, int nivel) {
        if (no == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(no.getValor());
        if (no.getEsq() != null || no.getDir() != null) {
            sb.append(" -> [E:").append(imprimirArvore(no.getEsq(), nivel + 1)).append(", D:")
                    .append(imprimirArvore(no.getDir(), nivel + 1)).append("]");
        }
        sb.append(")");
        return sb.toString();
    }
}
