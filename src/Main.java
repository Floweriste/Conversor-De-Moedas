import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<String> historico = new ArrayList<>();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        boolean executando = true;

        while (executando) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1. Dólar (USD) → Real (BRL)");
            System.out.println("2. Real (BRL) → Dólar (USD)");
            System.out.println("3. Euro (EUR) → Real (BRL)");
            System.out.println("4. Real (BRL) → Euro (EUR)");
            System.out.println("5. Dólar (USD) → Euro (EUR)");
            System.out.println("6. Euro (EUR) → Dólar (USD)");
            System.out.println("7. Libra Esterlina (GBP) → Real (BRL)");
            System.out.println("8. Real (BRL) → Libra Esterlina (GBP)");
            System.out.println("9. Iene (JPY) → Real (BRL)");
            System.out.println("10. Real (BRL) → Iene (JPY)");
            System.out.println("11. Ver histórico de conversões");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número.");
                continue;
            }

            if (opcao == 0) {
                System.out.println("Encerrando o programa... Até logo!");
                executando = false;
                continue;
            }

            if (opcao == 11) {
                System.out.println("\n=== Histórico de Conversões ===");
                if (historico.isEmpty()) {
                    System.out.println("Nenhuma conversão registrada ainda.");
                } else {
                    historico.forEach(System.out::println);
                }
                continue;
            }

            String de = "";
            String para = "";

            switch (opcao) {
                case 1 -> { de = "USD"; para = "BRL"; }
                case 2 -> { de = "BRL"; para = "USD"; }
                case 3 -> { de = "EUR"; para = "BRL"; }
                case 4 -> { de = "BRL"; para = "EUR"; }
                case 5 -> { de = "USD"; para = "EUR"; }
                case 6 -> { de = "EUR"; para = "USD"; }
                case 7 -> { de = "GBP"; para = "BRL"; }
                case 8 -> { de = "BRL"; para = "GBP"; }
                case 9 -> { de = "JPY"; para = "BRL"; }
                case 10 -> { de = "BRL"; para = "JPY"; }
                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
                }
            }

            System.out.print("Digite o valor a converter: ");
            double valor;
            try {
                valor = Double.parseDouble(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
                continue;
            }

            try {
                double convertido = ConversorMoedas.converter(de, para, valor);
                String horaAtual = LocalDateTime.now().format(formatoHora);
                System.out.printf("Valor convertido: %.2f %s%n", convertido, para);


                String registro = String.format("[%s] %.2f %s → %.2f %s", horaAtual, valor, de, convertido, para);
                historico.add(registro);

                System.out.println("Conversão registrada com sucesso!");

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        entrada.close();
    }
}
