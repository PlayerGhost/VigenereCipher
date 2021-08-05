
package cifra2;

public class Alfabeto {
    private char letra;
    private int index;
    private Alfabeto proximo;
    private Alfabeto anterior;

    public Alfabeto(char letra, int index) {
        this.letra = letra;
        this.index = index;
        this.proximo = null;
        this.anterior = null;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Alfabeto getProximo() {
        return proximo;
    }

    public void setProximo(Alfabeto proximo) {
        this.proximo = proximo;
    }

    public Alfabeto getAnterior() {
        return anterior;
    }

    public void setAnterior(Alfabeto anterior) {
        this.anterior = anterior;
    }
}
