import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Reserva[] reservas = new Reserva[10];
        int contador = 0;

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Nova reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Ordenar por dias (decrescente)");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    if (contador < reservas.length) {

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        // Tipo de quarto (sem preço fixo)
                        System.out.println("Escolha o tipo de quarto:");
                        System.out.println("1 - Standard");
                        System.out.println("2 - Luxo(R$1000)");
                        System.out.println("3 - Presidencial(R$2000)");
                        System.out.print("Opção: ");

                        int opcaoQuarto = sc.nextInt();
                        sc.nextLine();

                        String tipo;

                        switch (opcaoQuarto) {
                            case 1:
                                tipo = "Standard";
                                break;
                            case 2:
                                tipo = "Luxo";
                                break;
                            case 3:
                                tipo = "Presidencial";
                                break;
                            default:
                                System.out.println("Opção inválida! Usando Standard.");
                                tipo = "Standard";
                        }

                        // Número de dias
                       int dias;
                        do {
                            System.out.print("Número de dias: ");
                            dias = sc.nextInt();
                            sc.nextLine();

                            if (dias < 1) {
                                System.out.println("Erro! O número de dias deve ser pelo menos 1.");
                            }

                        } while (dias < 1);

                        // Valor da diária com validação
                        double diaria;

                        do {
                            System.out.print("Valor da diária: ");
                            diaria = sc.nextDouble();
                            sc.nextLine();

                            if (diaria <= 0) {
                                System.out.println("Valor inválido! Digite um valor maior que 0.");
                            }

                        } while (diaria <= 0);

                        reservas[contador] = new Reserva(nome, tipo, dias, diaria);
                        contador++;

                        System.out.println("Reserva cadastrada!");

                    } else {
                        System.out.println("Limite de reservas atingido!");
                    }
                    break;

                case 2:
                    for (int i = 0; i < contador; i++) {
                        System.out.println(reservas[i]);
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome para busca: ");
                    String busca = sc.nextLine().toLowerCase();

                    boolean encontrou = false;

                    for (int i = 0; i < contador; i++) {
                        if (reservas[i].getNomeHospede().toLowerCase().contains(busca)) {
                            System.out.println(reservas[i]);
                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Nenhuma reserva encontrada.");
                    }
                    break;

                case 4:
                    // Ordenação (Bubble Sort)
                    for (int i = 0; i < contador - 1; i++) {
                        for (int j = 0; j < contador - i - 1; j++) {
                            if (reservas[j].getNumeroDias() < reservas[j + 1].getNumeroDias()) {

                                Reserva temp = reservas[j];
                                reservas[j] = reservas[j + 1];
                                reservas[j + 1] = temp;
                            }
                        }
                    }

                    System.out.println("Reservas ordenadas!");
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}