public class ListaUtil {


    // Conta usando o coringa "?". Aceita qualquer tipo de lista (Vetor ou Encadeada)
    public static int count(Lista<?> lista, Object elemento) {
        int contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) != null && lista.get(i).equals(elemento)) {
                contador++;
            }
        }
        return contador;
    }


    // Pega o maior da lista usando coringa limitado, pra obrigar a ter o compareTo
    public static <T extends Comparable<T>> T max(Lista<T> lista) {
        if (lista == null || lista.size() == 0) throw new IllegalArgumentException("Lista vazia");
        T maior = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).compareTo(maior) > 0) { maior = lista.get(i); }
        }
        return maior;
    }


    // Mesma coisa do de cima, mas pega o menor
    public static <T extends Comparable<T>> T min(Lista<T> lista) {
        if (lista == null || lista.size() == 0) throw new IllegalArgumentException("Lista vazia");
        T menor = lista.get(0);
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i).compareTo(menor) < 0) { menor = lista.get(i); }
        }
        return menor;
    }
}
