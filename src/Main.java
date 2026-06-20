public class Main {
   public static void main(String[] args) {
       System.out.println("=== TESTANDO MÉTODOS DE ARRAY EXTRAÍDOS ===");
       Integer[] inteiros = {5, 12, 5, 8, 2};
       String[] strings = {"Java", "Generics", "Java", "IFRS"};


       // 1) Testando contagem, maior e menor em vetores puros
       System.out.println("No vetor [Java, Generics, Java, IFRS], a palavra 'Java' aparece: " + ArrayUtil.count(strings, "Java") + " vezes.");
       System.out.println("No vetor de números(5, 12, 5, 8, 2) o maior número encontrado é o: " + ArrayUtil.max(inteiros));
       System.out.println("No vetor de texto, a palavra que vem primeiro no dicionário (menor) é: " + ArrayUtil.min(strings));


       System.out.println("\n=== TESTANDO ESTRUTURA DE LISTA E UTILS ===");
       // 2) Criando a lista encadeada e adicionando os 4 itens do roteiro
       Lista<String> listaEncadeada = new ListaEncadeada<>();
       listaEncadeada.add("Estruturas");
       listaEncadeada.add("Dados", 1);
       listaEncadeada.add("Generics");
       listaEncadeada.add("Dados");


       System.out.print("Lista final ordenada alfabeticamente: ");
       ListaUtil.imprimirOrdenado(listaEncadeada);


       System.out.println("Coloquei 4 palavras na lista. O tamanho total dela é: " + listaEncadeada.size());
       System.out.println("Fui na posição 1 da lista e puxei a palavra que estava lá: " + listaEncadeada.get(1));


       // 3) Testando a remoção por posição e por valor
       listaEncadeada.remove(0); // Apaga "Estruturas"
       boolean apagouDados = listaEncadeada.remove("Dados"); // Apaga o primeiro "Dados" que achar
       System.out.println("Mandei apagar a palavra 'Dados' da lista por valor. Conseguiu? " + (apagouDados ? "Sim, apagou!" : "Não achou."));


       // 4) Testes usando as regras de Coringa (Wildcard) na ListaUtil
       System.out.println("Depois dos testes de apagar, sobrou a palavra 'Dados' na lista? " + ListaUtil.count(listaEncadeada, "Dados") + " vez(es).");
       System.out.println("Das palavras que sobraram na lista, qual vai mais longe no alfabeto (maior)? " + ListaUtil.max(listaEncadeada));
       System.out.println("E qual sobrou que vem primeiro no alfabeto (menor)? " + ListaUtil.min(listaEncadeada));
   }
}
