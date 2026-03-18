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
        }
        topo++;
        pilha[topo] = arvore;
        System.out.println("Arvore inserida na pilha");
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