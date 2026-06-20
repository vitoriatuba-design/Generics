public class Main {
    public static void main(String[] args) {
        // Testando a primeira parte (ArrayUtil)
        String[] strings = {"Java", "Generics", "Java"};
        System.out.println("Vezes que apareceu 'Java': " + ArrayUtil.count(strings, "Java"));


        // Testando as listas e utilitários
        Lista<String> lista = new ListaEncadeada<>();
        lista.add("Estruturas");
        lista.add("Dados");
        lista.add("Generics");


        System.out.println("Maior palavra da lista: " + ListaUtil.max(lista));
    }
}
