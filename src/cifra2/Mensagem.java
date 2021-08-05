
package cifra2;

public class Mensagem {
    private String bloco1;
    private String bloco2;

    public Mensagem(String bloco1) {
        this.bloco1 = bloco1;
        this.bloco2 = bloco2;
    }
    
    public Mensagem(String bloco1, String bloco2) {
        this.bloco1 = bloco1;
        this.bloco2 = bloco2;
    }

    public String getBloco1() {
        return bloco1;
    }

    public void setBloco1(String bloco1) {
        this.bloco1 = bloco1;
    }

    public String getBloco2() {
        return bloco2;
    }

    public void setBloco2(String bloco2) {
        this.bloco2 = bloco2;
    }
}
