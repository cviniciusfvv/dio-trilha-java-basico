import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Declaração das variáveis
        int numeroAgencia;
        String nomeCliente;
        int numeroConta;
        double saldo;

        // Entrada e validação dos dados
        System.out.print("Por favor, digite o número da Agência: ");
        numeroAgencia = lerInteiroPositivo(scanner, "Número de agência");

        System.out.print("Digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();
        while (nomeCliente.isEmpty()) {
            System.out.println("Nome do cliente não pode ser vazio.");
            System.out.print("Digite o nome do cliente: ");
            nomeCliente = scanner.nextLine();
        }

        System.out.print("Digite o número da conta: ");
        numeroConta = lerInteiroPositivo(scanner, "Número da conta");

        System.out.print("Digite o saldo: ");
        saldo = lerDoublePositivo(scanner, "Saldo");

        // Saída formatada
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + numeroAgencia + ", conta " + numeroConta + ".");
        System.out.println("Seu saldo " + currencyFormatter.format(saldo) + " já está disponível para saque.");

        scanner.close();
    }

    // Método para ler um número inteiro positivo
    private static int lerInteiroPositivo(Scanner scanner, String mensagem) {
        int numero;
        do {
            try {
                System.out.print(mensagem + ": ");
                numero = scanner.nextInt();
                if (numero <= 0) {
                    System.out.println(mensagem + " deve ser um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                scanner.next(); // Limpar o buffer
                numero = -1; // Forçar a repetição do loop
            }
        } while (numero <= 0);
        return numero;
    }

    // Método para ler um número decimal positivo
    private static double lerDoublePositivo(Scanner scanner, String mensagem) {
        double numero;
        do {
            try {
                System.out.print(mensagem + ": ");
                numero = scanner.nextDouble();
                if (numero <= 0) {
                    System.out.println(mensagem + " deve ser um número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número decimal.");
                scanner.next(); // Limpar o buffer
                numero = -1; // Forçar a repetição do loop
            }
        } while (numero <= 0);
        return numero;
    }
}