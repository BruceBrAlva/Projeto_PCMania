package pcmania;

public class Cliente {
    private String nome;
    private long cpf;
    private Computador[] computadores; // até 10

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[10];
    }

    // Adiciona computador conforme a promoção escolhida
    public void addComputador(Computador computador) {
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null) {
                computadores[i] = computador;
                break;
            }
        }
    }

    public float calculaTotalCompra() {
        float total = 0f;
        for (Computador c : computadores) {
            if (c != null) total += c.getPreco();
        }
        return total;
    }

    public Computador[] getComputadores() { return computadores; }

    public void mostraResumoCompra() {
        System.out.println("Cliente: " + nome + "  CPF: " + cpf);
        System.out.println();
        for (Computador c : computadores) {
            if (c != null) c.mostraPCConfigs();
        }
        System.out.println("TOTAL: R$ " + calculaTotalCompra());
    }
}