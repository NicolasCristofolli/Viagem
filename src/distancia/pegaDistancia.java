package distancia;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class pegaDistancia {
    Scanner leitura = new Scanner(System.in);
    private String cidadeOrigem;
    private String cidadeDestino;

    public double resultado;


    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }


    public void pegaDistancia() {

            System.out.println("Digite sua cidade de origem");
            setCidadeOrigem(leitura.nextLine().toUpperCase());

            System.out.println("Digite sua cidade de destino");
            setCidadeDestino(leitura.nextLine().toUpperCase());

            //caso tenha espaço no nome da cidade vai mudar para %20
            String cidadeOrigemURL = getCidadeOrigem().replace(" ", "%20");
            String cidadeDestinoURL = getCidadeDestino().replace(" ", "%20");

            Document doc = null;
            //pega o link com as cidade desejadas
        try {
            doc = Jsoup.connect("https://www.distanciasentrecidades.com/pesquisa?from=" + cidadeOrigemURL + "&to=" + cidadeDestinoURL).get();
        } catch (Exception e) {
        }

        Element resultadoElement = doc.getElementById("kmsruta");
        this.resultado = Double.parseDouble(resultadoElement.text());

        System.out.println("================================================");
        System.out.println(" ");
        System.out.println("A distancia entre " + getCidadeOrigem() + " e " + getCidadeDestino() + " é de: " + resultado + "km");
    }
}
