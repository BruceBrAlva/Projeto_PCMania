package pcmania;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwareBasicos;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, SistemaOperacional so) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = so;
        this.hardwareBasicos = new HardwareBasico[3];
    }

    public boolean addHardware(HardwareBasico hb) {
        for (int i = 0; i < hardwareBasicos.length; i++) {
            if (hardwareBasicos[i] == null) {
                hardwareBasicos[i] = hb;
                return true;
            }
        }
        return false;
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public float getPreco() { return preco; }

    public void mostraPCConfigs() {
        System.out.println("=== PC " + marca + " ===");
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        System.out.println("Hardware Básico:");
        for (HardwareBasico hb : hardwareBasicos) {
            if (hb != null) {
                System.out.println(" - " + hb.getNome() + " - " + hb.getCapacidade());
            }
        }
        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + "Gb");
        }
        System.out.println("Preço: R$ " + preco);
        System.out.println();
    }
}