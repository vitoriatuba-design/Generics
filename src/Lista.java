//  interface genérica 2)
public interface Lista <T> {
    void add(T valor); // recebe valor e joga pro final da list
    void add(T valor,  int pos); // abre espaço e coloca o valor onde eu quiser
    T get(int pos); // vai até onde eu pedi(posicao), puxa o elemente e me devolve como T
    T remove(int pos); // remove o elemento da posição e me diz o valor apagado
    boolean remove(T valor); // procura valor na lista, se acha e apaga me devolve true
    int size(); // conta e me diz qnts elementos tem ali na list
}
