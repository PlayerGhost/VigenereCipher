
package cifra2;

import java.util.Scanner;

public class Cifra2 {

    public static void main(String[] args) {
        Encriptador cifra = new Encriptador();
        Scanner input = new Scanner(System.in);
        int aux;
        
        System.out.println("Escolha sua operação (1 - encriptação, 2 - decriptação)");
        aux = input.nextInt();
        input.nextLine();
        
        if(aux < 1 || aux > 2){
            System.out.println("Opção invalida!");
        }else{
            if(aux == 1){
                System.out.println("Informe o texto claro");
                String texto = input.nextLine();   
                
                System.out.println("Informe a chave");
                String chave = input.next();
                
                System.out.println("Informe o tamanho do bloco");
                int bloco = input.nextInt();
                
                cifra.encriptar(texto, chave, bloco);
            }else{
                System.out.println("Informe o criptograma");
                String criptograma = input.nextLine();
                
                System.out.println("Informe a chave");
                String chave = input.next();
                
                System.out.println("Informe o tamanho do bloco");
                int bloco = input.nextInt();
                
                cifra.decriptar(criptograma, chave, bloco);
            }
        }    
    } 
}
