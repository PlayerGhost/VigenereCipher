
package cifra2;

public class ListaCircular {
    private Alfabeto primeiro;
    private Alfabeto ultimo;
    private Alfabeto aux;

    public ListaCircular() {
        primeiro = null;
        ultimo = null;
        aux = null;
    }
    
    public void adicionar(char letra, int index){
        Alfabeto novo  = new Alfabeto(letra, index);
        
        if (primeiro == null){
            primeiro = novo;
            ultimo = novo;
            novo.setProximo(primeiro);
            novo.setAnterior(primeiro);
        }else{
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
            ultimo.setProximo(primeiro);
            primeiro.setAnterior(ultimo);
        }
    }
    
    public Alfabeto posicao(char letra){
        aux = primeiro;
        
        do{
            if(aux.getLetra() == Character.toUpperCase(letra)){
                break;
            }
            
            aux = aux.getProximo();
        }while(aux != primeiro);
        
        return aux;
    }
}
