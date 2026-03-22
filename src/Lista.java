public class Lista {
    ListaNo cabeca, rabo;

    public ListaNo inserirNo(String valor) {
        this.cabeca = this.insercaoRecursiva(this.cabeca, valor);
        return this.cabeca;
    }

    private ListaNo insercaoRecursiva(ListaNo no, String valor) {
        ListaNo novoNo = new ListaNo(valor);

        if (cabeca == null) {
            this.cabeca = novoNo;
            this.rabo = novoNo;
            return this.cabeca;
        }

        if (no == null) {
            this.rabo = novoNo;
            return novoNo;
        }

        no.setProximo(insercaoRecursiva(no, valor));

        return no;
    }
}