package pcmania;

import java.util.Scanner;

public class Main {

    private static final int MATRICULA = 326;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Promoção 1
        Computador promo1 = new Computador(
                "Apple",
                MATRICULA,
                new SistemaOperacional("macOS Sequoia", 64)
        );
        promo1.addHardware(new HardwareBasico("Pentium Core i3", 2200));
        promo1.addHardware(new HardwareBasico("Memória RAM", 8));
        promo1.addHardware(new HardwareBasico("HD", 500));
        promo1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        // Promoção 2
        Computador promo2 = new Computador(
                "Samsung",
                MATRICULA + 1234,
                new SistemaOperacional("Windows 8", 64)
        );
        promo2.addHardware(new HardwareBasico("Pentium Core i5", 3370));
        promo2.addHardware(new HardwareBasico("Memória RAM", 16));
        promo2.addHardware(new HardwareBasico("HD", 1000));
        promo2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        // Promoção 3
        Computador promo3 = new Computador(
                "Dell",
                MATRICULA + 5678,
                new SistemaOperacional("Windows 10", 64)
        );
        promo3.addHardware(new HardwareBasico("Pentium Core i7", 4500));
        promo3.addHardware(new HardwareBasico("Memória RAM", 32));
        promo3.addHardware(new HardwareBasico("HD", 2000));
        promo3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1024));

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu CPF (apenas números): ");
        long cpf = Long.parseLong(sc.nextLine());

        Cliente cliente = new Cliente(nome, cpf);

        int opcao;
        do {
            System.out.println("=== PC Mania - Promoções ===");
            System.out.println("1 - Promoção 1 (Apple)  - R$ " + (MATRICULA));
            System.out.println("2 - Promoção 2 (Samsung) - R$ " + (MATRICULA + 1234));
            System.out.println("3 - Promoção 3 (Dell)    - R$ " + (MATRICULA + 5678));
            System.out.println("0 - Finalizar compra");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: cliente.addComputador(cloneComputador(promo1)); break;
                case 2: cliente.addComputador(cloneComputador(promo2)); break;
                case 3: cliente.addComputador(cloneComputador(promo3)); break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        // Mostra resumo e envia pedido
        cliente.mostraResumoCompra();
        ProcessarPedido.enviar(cliente.getComputadores());
    }

    // Clona uma configuração de computador para não compartilhar o mesmo objeto
    private static Computador cloneComputador(Computador modelo) {
        // Como os campos são privados, reconstruímos com os mesmos dados
        if (modelo == null) return null;

        // Reconstroi com base na marca para mapear a promoção
        if (modelo.getPreco() == MATRICULA) {
            Computador c = new Computador("Apple", MATRICULA, new SistemaOperacional("macOS Sequoia", 64));
            c.addHardware(new HardwareBasico("Pentium Core i3", 2200));
            c.addHardware(new HardwareBasico("Memória RAM", 8));
            c.addHardware(new HardwareBasico("HD", 500));
            c.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
            return c;
        } else if (modelo.getPreco() == MATRICULA + 1234) {
            Computador c = new Computador("Samsung", MATRICULA + 1234, new SistemaOperacional("Windows 8", 64));
            c.addHardware(new HardwareBasico("Pentium Core i5", 3370));
            c.addHardware(new HardwareBasico("Memória RAM", 16));
            c.addHardware(new HardwareBasico("HD", 1000));
            c.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
            return c;
        } else {
            Computador c = new Computador("Dell", MATRICULA + 5678, new SistemaOperacional("Windows 10", 64));
            c.addHardware(new HardwareBasico("Pentium Core i7", 4500));
            c.addHardware(new HardwareBasico("Memória RAM", 32));
            c.addHardware(new HardwareBasico("HD", 2000));
            c.addMemoriaUSB(new MemoriaUSB("HD Externo", 1024));
            return c;
        }
    }
}