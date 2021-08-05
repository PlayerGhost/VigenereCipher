
package cifra2;

public class Encriptador{
    ListaCircular tabela;
    Fila fila;
    Fila fila2;
    Alfabeto aux;
    Mensagem aux1;
      
    public Encriptador() {
        tabela = new ListaCircular();
        fila = new Fila();
        fila2 = new Fila();
        aux = null;
        aux1 = null;
    }
    
    public void preencherAlfabeto(){
        char c = 'A';
        
        for(int i = 0; i < 26; i++){
            tabela.adicionar(c++, i);
        }
    }
    
    public void encriptar(String texto, String chave, int size){
        preencherAlfabeto();
        int index = 0;
        String key = chave;
        
        while (index < texto.length()){
            aux1 = new Mensagem(texto.substring(index, Math.min((index+size), texto.length())));
            fila.enqueue(aux1);
            
            index+= size;
        }
        
        aux1 = (Mensagem) fila.pick().getElemento();
        
        while(key.length() < aux1.getBloco1().length()){
            key += key;
        }
        
        while(!fila.isEmpty()){
            Mensagem bloco1 = (Mensagem) fila.dequeue().getElemento();
            String bloco2 = "";
            
            for (int i = 0; i < bloco1.getBloco1().length(); i++){
                bloco2 += ConsultarEncript(bloco1.getBloco1().charAt(i), key.charAt(i));
            }
            
            aux1 = new Mensagem(bloco1.getBloco1(), bloco2);
            
            fila2.enqueue(aux1);
        }
        
        printCript();
    }
    
    public void decriptar(String texto, String chave, int size){
        preencherAlfabeto();
        int index = 0;
        String key = chave;
        
        while (index < texto.length()){
            aux1 = new Mensagem(texto.substring(index, Math.min((index+size), texto.length())));
            fila.enqueue(aux1);
            
            index+= size;
        }
        
        aux1 = (Mensagem) fila.pick().getElemento();
        
        while(key.length() < aux1.getBloco1().length()){
            key += key;
        }
        
        while(!fila.isEmpty()){
            Mensagem bloco1 = (Mensagem) fila.dequeue().getElemento();
            String bloco2 = "";
            
            for (int i = 0; i < bloco1.getBloco1().length(); i++){
                bloco2 += ConsultarDecript(bloco1.getBloco1().charAt(i), key.charAt(i));
            }
            
            aux1 = new Mensagem(bloco1.getBloco1(), bloco2);
            
            fila2.enqueue(aux1);
        }
        
        printDecript();
    }
    
    public char ConsultarEncript(char letra, char chave){
        boolean noLetter = false;
        boolean upperCase = false;
        char x = 0;
        int index = 0;
        
        if(letra < 'A' || letra > 'Z'){
            if(letra < 'a' || letra > 'z'){
                noLetter = true;
            }else{
                aux = tabela.posicao(Character.toUpperCase(chave));              
            }
        }else{
            upperCase = true;
            aux = tabela.posicao(chave);      
        }
        
        if(noLetter){
            return letra;
        }else{
            index = aux.getIndex();
            aux = tabela.posicao(Character.toUpperCase(letra)); 
            
            for(int i = 0; i <= index; i++){
                x = aux.getLetra();
                aux = aux.getProximo();
            }
            
            if(upperCase){
                return x;
            }else{
                return Character.toLowerCase(x);
            }
        }    
    }
    
    public char ConsultarDecript(char letra, char chave){
        boolean noLetter = false;
        boolean upperCase = false;
        char x = letra;
        int index = 0;
        
        if(letra < 'A' || letra > 'Z'){
            if(letra < 'a' || letra > 'z'){
                noLetter = true;
            }else{
                aux = tabela.posicao(Character.toUpperCase(chave));              
            }
        }else{
            upperCase = true;
            aux = tabela.posicao(chave);      
        }
        
        if(noLetter){
            return letra;
        }else{
            index = aux.getIndex();
            aux = tabela.posicao(Character.toUpperCase(letra)); 
            
            for(int i = 0; i <= index; i++){
                x = aux.getLetra();
                aux = aux.getAnterior();
            }

            if(upperCase){
                return x;
            }else{
                return Character.toLowerCase(x);
            }
        }
    }
    
    public void printCript(){
        System.out.println(" ");
        System.out.println("Texto claro:");
         
        while(!fila2.isEmpty()){
            aux1 = (Mensagem) fila2.dequeue().getElemento();
            fila.enqueue(aux1);
            
            System.out.print(aux1.getBloco1());
        }
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Criptograma:");
        
        while(!fila.isEmpty()){
            aux1 = (Mensagem) fila.dequeue().getElemento();
            
            System.out.print(aux1.getBloco2());
        }
        
        System.out.println(" ");
    }
    
    public void printDecript(){
        System.out.println(" ");
        System.out.println("Criptograma:");
        
        while(!fila2.isEmpty()){
            aux1 = (Mensagem) fila2.dequeue().getElemento();
            fila.enqueue(aux1);
            
            System.out.print(aux1.getBloco1());
        }
        
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Texto claro:");
        
        while(!fila.isEmpty()){
            aux1 = (Mensagem) fila.dequeue().getElemento();
            
            System.out.print(aux1.getBloco2());
        }
        
        System.out.println(" ");
    }
}
