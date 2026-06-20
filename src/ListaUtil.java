//  Classe com Coringas (Wildcards) (3
public class ListaUtil {


       // O coringa "?" deve aceitar qualquer tipo de lista
       public static int count(Lista<?> lista, Object elemento) {
           int contador = 0;
           for (int i = 0; i < lista.size(); i++) {
               Object item = lista.get(i); // vai na lista e pega o item da posição
               // usa equals porque == da erro com String (texto)
               if (item != null && item.equals(elemento)) {
                   contador++;
               }
           }
           return contador; // devolve o total que contou
       }


       public static <T extends Comparable<T>> T max(Lista<T> lista) {
           if (lista == null || lista.size() == 0) {
               throw new IllegalArgumentException("Lista vazia ou null");
           }
           T maior = lista.get(0); // chuta que o primeiro da lista é o maior
           for (int i = 1; i < lista.size(); i++) {
               T item = lista.get(i);
               // compara o atual com o maior salvo. Se der > 0, achei um maior
               if (item.compareTo(maior) > 0) {
                   maior = item;
               }
           }
           return maior; // devolve o maior de todos
       }


       // Mesma lógica do de cima, só muda a checagem pra achar o menor
       public static <T extends Comparable<T>> T min(Lista<T> lista) {
           if (lista == null || lista.size() == 0) {
               throw new IllegalArgumentException("Lista vazia ou null");
           }
           T menor = lista.get(0); // chuta que o primeiro é o menor
           for (int i = 1; i < lista.size(); i++) {
               T item = lista.get(i);
               // se o resultado der < 0, significa que achei um menor ainda
               if (item.compareTo(menor) < 0) {
                   menor = item;
               }
           }
           return menor; // devolve o menor de todos
       }
   //Imprime os elementos ordenados sem alterar a lista original
   public static <T extends Comparable<T>> void imprimirOrdenado(Lista<T> lista) {
       if (lista == null || lista.size() == 0) {
           System.out.println("[]");
           return;
       }


       int tamanho = lista.size();


       // Cria um vetor temporário para clonar os dados da lista
       @SuppressWarnings("unchecked")
       T[] temp = (T[]) new Comparable[tamanho];
       for (int i = 0; i < tamanho; i++) {
           temp[i] = lista.get(i);
       }


       // Ordena o vetor temporário (Bubble Sort) usando o compareTo
       for (int i = 0; i < tamanho - 1; i++) {
           for (int j = 0; j < tamanho - i - 1; j++) {
               if (temp[j].compareTo(temp[j + 1]) > 0) {
                   T auxiliar = temp[j];
                   temp[j] = temp[j + 1];
                   temp[j + 1] = auxiliar;
               }
           }
       }


       // Imprime o vetor já ordenado no formato [item1, item2, ...]
       System.out.print("[");
       for (int i = 0; i < tamanho; i++) {
           System.out.print(temp[i]);
           if (i < tamanho - 1) {
               System.out.print(", ");
           }
       }
       System.out.println("]");
   }
}
