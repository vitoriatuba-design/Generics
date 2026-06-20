public class ArrayUtil {

    // Pra contar quantas vezes aparece no array
    public static <T> int count(T[] vetor, T elemento) {
        if (vetor == null) return 0;
        int contador = 0;
        for (T item : vetor) {
            // tive q usar equals porque == da erro com String
            if (item != null && item.equals(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    // Pega o maior do array
    public static <T extends Comparable<T>> T max(T[] vetor) { // pro Java aceitar o compareTo ali
        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("Array vazio ou null"); // Caso o vetor seja nulo ou vazio
        }
        T maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            // se o atual for maior que o salvo, atualiza
            if (vetor[i].compareTo(maior) > 0) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    // Msm lógica do de cima, só muda o sinal
    public static <T extends Comparable<T>> T min(T[] vetor) {
        if (vetor == null || vetor.length == 0) {
            throw new IllegalArgumentException("Array vazio ou null");
        }
        T menor = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i].compareTo(menor) < 0) {
                menor = vetor[i];
            }
        }
        return menor;
    }
}