import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;

public class GeradorNumerosMegaSena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de números aleatórios a serem gerados (entre 1 e 60): ");
        int quantidade = scanner.nextInt();

        if (quantidade < 1 || quantidade > 60) {
            System.out.println("Erro: A quantidade deve ser entre 1 e 60.");
            return;
        }

        long tempoInicio = System.currentTimeMillis();
        Set<Integer> numerosGerados = gerarNumerosAleatorios(quantidade);
        long tempoFim = System.currentTimeMillis();

        System.out.println("Números gerados: " + numerosGerados);
        long tempoExecucao = tempoFim - tempoInicio;
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");

        scanner.close();
    }

    public static Set<Integer> gerarNumerosAleatorios(int quantidade) {
        Set<Integer> numeros = new HashSet<>();
        Random geradorAleatorio = new Random();

        while (numeros.size() < quantidade) {
            int numero = geradorAleatorio.nextInt(60) + 1;
            if (!numeros.contains(numero)) {
                numeros.add(numero);
            }
        }
        return numeros;
    }
