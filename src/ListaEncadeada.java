public class ListaEncadeada<T> implements Lista<T> {


    private Node<T> inicio;
    private int tamanho;


    // nó q guarda o valor e aponta pro próximo
    private static class Node<T> {
        T dado;
        Node<T> proximo;
        Node(T dado) { this.dado = dado; }
    }


    @Override
    public void add(T valor) {
        // joga direto pro final da lista
        add(valor, tamanho);
    }


    @Override
    public void add(T valor, int pos) {
        if (pos < 0 || pos > tamanho) throw new IllegalArgumentException("Posição errada");
        Node<T> novoNo = new Node<>(valor);


        if (pos == 0) {
            novoNo.proximo = inicio;
            inicio = novoNo;
        } else {
            // Pra correr a lista até achar onde vai enfiar o nó
            Node<T> anterior = inicio;
            for (int i = 0; i < pos - 1; i++) {
                anterior = anterior.proximo;
            }
            novoNo.proximo = anterior.proximo;
            anterior.proximo = novoNo;
        }
        tamanho++;
    }


    @Override
    public T get(int pos) {
        if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
        Node<T> atual = inicio;
        for (int i = 0; i < pos; i++) { atual = atual.proximo; }
        return atual.dado;
    }


    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
        T excluido;
        if (pos == 0) {
            excluido = inicio.dado;
            inicio = inicio.proximo;
        } else {
            Node<T> anterior = inicio;
            for (int i = 0; i < pos - 1; i++) { anterior = anterior.proximo; }
            excluido = anterior.proximo.dado;
            anterior.proximo = anterior.proximo.proximo; // Pula o nó excluído
        }
        tamanho--;
        return excluido;
    }


    @Override
    public boolean remove(T valor) {
        Node<T> atual = inicio;
        Node<T> anterior = null;
        while (atual != null) {
            if (atual.dado != null && atual.dado.equals(valor)) {
                if (anterior == null) inicio = atual.proximo;
                else anterior.proximo = atual.proximo;
                tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }


    @Override
    public int size() { return this.tamanho; }
}
