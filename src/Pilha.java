public class Pilha {
    ArvoreAVL[] pilha;
    int topo;
    int tamanho;

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        pilha = new ArvoreAVL[tamanho];
        topo = -1;
    }

    public void push(ArvoreAVL arvore) {
        if (topo == tamanho - 1) {
            System.out.println("Pilha cheia");
            return;
        }
        topo++;
        pilha[topo] = arvore;
    }

    public ArvoreAVL pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
            return null;
        }
        ArvoreAVL arvore = pilha[topo];
        topo--;
        return arvore;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int getTamanho() {
        return topo + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pilha: [vazia]";
        }
        StringBuilder sb = new StringBuilder("Pilha: [tamanho=").append(getTamanho()).append(", topo=[");
        for (int i = topo; i >= 0; i--) {
            sb.append(pilha[i].raiz != null ? pilha[i].raiz.getValor() : "null");
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]]");
        return sb.toString();
    }
}