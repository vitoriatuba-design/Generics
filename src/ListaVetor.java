public class ListaVetor<T> implements Lista<T> {
   private T[] itens;
   private int tamanho;


   @SuppressWarnings("unchecked") // O SuppressWarnings pra barrar a msg sobre o perigo desse cast.
   public ListaVetor(){
       // O Java proíbe criar 'new T[]' direto. A saída foi criar array de Object e forçar o cast (T[]).
       this.itens = (T[]) new Object[10];
       this.tamanho = 0;
   }


   private void garantirCapacidade(){
       if ( tamanho == itens.length){
           @SuppressWarnings("unchecked")
           T[] novoVetor = (T[]) new Object[itens.length * 2]; // O tamanho dobra caso encha (tem 10)
           System.arraycopy(itens, 0, novoVetor, 0, itens.length); //copia elementos de um array para outro
           this.itens = novoVetor;
       }
   }


   @Override
   public void add(T valor) {
       garantirCapacidade();//checa espaço
       itens[tamanho++] = valor; //coloca na ultm vaga e soma 1 no tamanho
   }


   @Override
   public void add(T valor, int pos) {
       if (pos < 0 || pos > tamanho) throw new IllegalArgumentException("Posição Errada");
       garantirCapacidade();
       // empurra pra frente o array para abrir espaço
       for (int i = tamanho; i > pos; i--) { itens[i] = itens[i - 1]; }
       itens[pos] = valor;
       tamanho++;
   }


   @Override
   public T get(int pos) {
       if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
       return itens[pos]; // vai direto na posi do array e pega
   }


   @Override
   public T remove(int pos) {
       if (pos < 0 || pos >= tamanho) throw new IllegalArgumentException("Posição errada");
       T excluido = itens[pos]; // salva quem vai apagar para devolver no fim
       // Puxa todo mundo de volta pra cobrir o cara que saiu
       for (int i = pos; i < tamanho - 1; i++) { itens[i] = itens[i + 1]; }
       itens[--tamanho] = null; // limpa a última sobra que ficou dupli
       return excluido;
   }


   @Override
   public boolean remove(T valor) {
       //varre o array procurando o elemento
       for (int i = 0; i < tamanho; i++) {
           if (itens[i] != null && itens[i].equals(valor)) {
               remove(i);// achou o cara, passa o indice pro remove de cima resolver
               return true;
           }
       }
       return false;
   }


   @Override
   public int size() {
       return this.tamanho; //devolve total itens salvos
   }
}