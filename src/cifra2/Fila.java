
package cifra2;

public class Fila {
    private No primeiro;
    private No ultimo;
    private No aux;

    public Fila() {
        primeiro = null;
        ultimo = null;
        aux = null;
    }

    public void enqueue(Mensagem bloco){
        No novo = new No(bloco);
        
        if (primeiro == null){
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;            
        }
    }
    
    public No dequeue(){
        aux = primeiro;
        
        primeiro = primeiro.getProximo();
        aux.setProximo(null);

        
        return aux;
    }
    
    public boolean isEmpty(){
        boolean status = false;
        
        if(primeiro == null){
            status = true;
        }
        
        return status;
    }
    
    public No pick(){
        aux = primeiro;
        
        return aux;
    }
}
