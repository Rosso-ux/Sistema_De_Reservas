public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    // Construtor
    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        setNumeroDias(numeroDias);
        setValorDiaria(valorDiaria);
    }

    // Getter
    public String getNomeHospede() {
        return nomeHospede;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    // Setter com validação
    public void setNumeroDias(int numeroDias) {
        if (numeroDias < 1) {
            System.out.println("Número de dias inválido! Definindo como 1.");
            this.numeroDias = 1;
        } else {
            this.numeroDias = numeroDias;
        }
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            System.out.println("Valor inválido! Definindo como 100.");
            this.valorDiaria = 100;
        } else {
            this.valorDiaria = valorDiaria;
        }
    }

    // Cálculo do total
    public double calcularValorTotal() {

        double total = numeroDias * valorDiaria;

        if (tipoQuarto.equalsIgnoreCase("Luxo")) {
            total += 1000;
        } else if (tipoQuarto.equalsIgnoreCase("Presidencial")) {
            total += 2000;
        }

        return total;
    }

    // toString
    @Override
    public String toString() {
        return "Hóspede: " + nomeHospede +
                " | Quarto: " + tipoQuarto +
                " | Dias: " + numeroDias +
                " | Total: R$ " + String.format("%.2f", calcularValorTotal());
    }
}