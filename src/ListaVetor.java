public class ListaVetor<T> implements Lista<T> {


    private T[] itens;
    private int tamanho;


    @SuppressWarnings("unchecked")
    public ListaVetor() {
        // gambiarra necessaria ja que java nao aceitou new T[10] direto
        // A saída é criar um array de Object e forçar o cast. O SuppressWarnings barra o aviso do Java
        this.itens = (T[]) new Object[10];
        this.tamanho = 0;
    }


    private void garantirCapacidade() {
        if (tamanho == itens.length) {
            @SuppressWarnings("unchecked")
            T[] novoVetor = (T[]) new Object[itens.length * 2]; // dobra o tamanho se encher
            System.arraycopy(itens, 0, novoVetor, 0, itens.length);
            this.itens = novoVetor;
        }
    }


    @Override
    public void add(T valor) {
        garantirCapacidade();
        itens[tamanho++] = valor;
    }


    @Override
    public void add(T valor, int pos) {
        if (pos < 0 || pos > tamanho) throw new IllegalArgumentException("Posição errada");
        garantirCapacidade();
        // Empurra o resto do array pra frente pra abrir espaço
        for (int i = tamanho; i > pos; i--) { itens[i] = itens[i - 1]; }
        itens[pos] = valor;
        tamanho++;
    }


    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
        return itens[pos];
    }


    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
        T excluido = itens[pos];
        // Puxa todo mundo de volta pra cobrir o buraco do cara que saiu
        for (int i = pos; i < tamanho - 1; i++) { itens[i] = itens[i + 1]; }
        itens[--tamanho] = null;
        return excluido;
    }


    @Override
    public boolean remove(T valor) {
        for (int i = 0; i < tamanho; i++) {
            if (itens[i] != null && itens[i].equals(valor)) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public int size() { return this.tamanho; }
}


