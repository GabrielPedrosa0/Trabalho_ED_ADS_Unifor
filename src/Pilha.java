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
}