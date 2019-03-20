/* *****************************************************************************************
*Autor: Nilton Cerqueira Bento de Oliveira Júnior
*Componente Curricular: MI-Programação 
*Concluido em: 05/02/2019
*Declaro que este código foi elaborado por mim de forma individual e não contém nenhum trecho 
*de código de outro colega ou de outro autor, tais como provindos de livros eapostilas, e 
*páginas ou documentos eletrônicos da Internet. Qualquer trecho de códigode outra autoria 
*que não a minha está destacado com uma citação para o autor e a fontedo código, e estou 
*ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************** */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.Cidade;
import util.Grafo;

/**
 *Classe Para escrever um arquivo de texto com os resultados do roteiro
 * @author Júnior Lopes
 */
public class WriterR {
    private Dijkstra dijkstra;

    public WriterR() {
        dijkstra = new Dijkstra();
    }
    /**
     * Escreve o roteiro e os dados em um arquivo .txt
     * @param roteiro
     * @param gas
     * @param consumo
     * @param distancia
     * @param ultimaCity
     * @param graph
     * @throws IOException 
     */
    public void escreverRota(ArrayList<Cidade> roteiro, float gas, float consumo,
            int distancia, Cidade ultimaCity, Grafo graph) throws IOException{
        File file = new File("./MelhorRota.txt");
        Float custo;
        List<Cidade> lista;
        lista = dijkstra.find_shortest_path(graph, ultimaCity, graph.search("Feira de Santana"));
        distancia += lista.get(0).get_distancia_cidade();
        
        custo = (distancia/consumo)*gas;
        
        if(file.exists())
            file.delete();
        BufferedWriter bfw = new BufferedWriter(new FileWriter("./MelhorRota.txt", true));
        bfw.write("A melhor rota de ida e volta é: ");
        bfw.newLine();
        bfw.newLine();
        bfw.flush();
        for(Cidade c: roteiro){
            bfw.write(c.getNome());
            bfw.newLine();
            bfw.flush();
        }
        bfw.newLine();
        bfw.write("Você vai gastar ao todo: " + custo  + " Reais");
        bfw.newLine();
        bfw.flush();
        bfw.write("porque a distancia foi de " + distancia + "km");
        bfw.newLine();
        bfw.flush();
        bfw.write("seu carro faz "+ consumo +"km por litro\ne a gasolina está de " + gas +" o litro");
        bfw.flush();
        bfw.close();
    }
    
}
