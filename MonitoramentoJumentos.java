//Alex Vitor dos Reis 
//Ra : 42521519

import java.util.Scanner;

public class MonitoramentoJumentos {

    public static double calcularTaxaReducao(int populacaoInicial, int populacaoAtual) {
        if (populacaoInicial <= 0) {
            return 0.0;
        }
        return (1.0 - (double) populacaoAtual / populacaoInicial) * 100.0;
    }
    
    public static boolean estaEmRiscoCritico(double taxaReducao) {
        return taxaReducao >= 90.0;
    }

    public static int simularImpactoAbate(int populacaoAtual, int abatesAnuais, int anosSimulados) {
        int populacaoRestante = populacaoAtual - (abatesAnuais * anosSimulados);
        return populacaoRestante;
    }

    public static void exibirDeclaracaoFinal(int populacaoRestante, int anos) {
        System.out.println("\n--- RESULTADO DA SIMULAÇÃO ---");
        if (populacaoRestante <= 0) {
            System.out.println("ALERTA! A população de jumentos foi extinta em " + anos + " anos, no pior cenário.");
        } else {
            System.out.println("População restante após " + anos + " anos: " + populacaoRestante + " jumentos.");
            System.out.println("Ainda há esperança! Iniciativas de conservação são vitais.");
        }
        System.out.println("\nPrograma de Monitoramento Finalizado.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int populacaoInicial = 1400000;
        final int populacaoAtual = 84000;
        final int abatesAnuais = 50000;

        System.out.println("=== S.O.S. JUMENTO NORDESTINO - SISTEMA DE MONITORAMENTO ===");
        System.out.println("População inicial de referência: " + populacaoInicial);
        System.out.println("População atual estimada: " + populacaoAtual);
        System.out.println("Abates anuais (simulados): " + abatesAnuais);

        double taxaReducao = calcularTaxaReducao(populacaoInicial, populacaoAtual);
        System.out.printf("\n[Análise Inicial] Taxa de Redução Histórica: %.2f%%\n", taxaReducao);

        boolean emRiscoCritico = estaEmRiscoCritico(taxaReducao);
        if (emRiscoCritico) {
            System.out.println("[Status] Espécie em Risco CRÍTICO (Redução > 90%)!");
        } else {
            System.out.println("[Status] Espécie em observação.");
        }

        System.out.print("\nQuantos anos futuros você deseja simular o impacto dos abates (Ex: 1, 3, 5)? ");
        int anosSimulados = scanner.nextInt();

        int populacaoRestante = simularImpactoAbate(populacaoAtual, abatesAnuais, anosSimulados);

        exibirDeclaracaoFinal(populacaoRestante, anosSimulados);

        scanner.close();
    }
}
