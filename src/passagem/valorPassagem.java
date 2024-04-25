package passagem;

import distancia.pegaDistancia;

import java.util.Scanner;


public class valorPassagem {
    Scanner leitura = new Scanner(System.in);
    pegaDistancia pegaDistancia = new pegaDistancia();
    private double onibusExecutivo = 4.50;
    private double onibusNormal = 2.25;

    public double getOnibusExecutivo() {
        return onibusExecutivo;
    }

    public double getOnibusNormal() {
        return onibusNormal;
    }

    public void valorPassagem() {
        pegaDistancia.pegaDistancia();
        double resultadoExecutivo = getOnibusExecutivo() * pegaDistancia.resultado;
        double resultadoNormal = getOnibusNormal() * pegaDistancia.resultado;

        String resultado;
        do {
            System.out.println("Qual transporte você deseja?");
            System.out.println("1 - Ônibus Executivo: R$" + resultadoExecutivo);
            System.out.println("2 - Ônibus Normal: R$" + resultadoNormal);
            System.out.println("3 - Digite 3 para sair");
            resultado = leitura.nextLine();
            switch(resultado) {
                case "1":
                    System.out.println("Obrigado pela preferencia, sua passagem de " + pegaDistancia.getCidadeOrigem() + " até " + pegaDistancia.getCidadeDestino() + " deu R$" + resultadoExecutivo);
                    break;
                case "2":
                    System.out.println("Obrigado pela preferencia, sua passagem de " + pegaDistancia.getCidadeOrigem() + " até " + pegaDistancia.getCidadeDestino() + " deu R$" + resultadoNormal);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Nao entendi");
            }

        } while (!resultado.equals("3"));
    }

}
