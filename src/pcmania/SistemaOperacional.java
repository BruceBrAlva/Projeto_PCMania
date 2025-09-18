package pcmania;

public class SistemaOperacional {
    private String nome;
    private int tipo; // bits

    public SistemaOperacional(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() { return nome; }
    public int getTipo() { return tipo; }
}