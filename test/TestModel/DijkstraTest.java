/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModel;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Aresta;
import util.Cidade;
import util.Grafo;
import java.util.ArrayList;
import model.Dijkstra;

/**
 *
 * @author João
 */
public class DijkstraTest {
    private static Grafo grafo;
    private static Cidade cidade1;
    private static Cidade cidade2;
    private static Cidade cidade3;
    private static Cidade cidade4;
    private static Cidade cidade5;
    private static Aresta aresta1;
    private static Aresta aresta2;
    private static Aresta aresta3;
    private static Aresta aresta4;
    private static Aresta aresta5;
    private static Aresta aresta6;
    private static Aresta aresta7;
    private static Aresta aresta8;
    private static Aresta aresta9;
    private static Aresta aresta10;
    private static Aresta aresta11;
    private static Aresta aresta12;
    private static Dijkstra dijkstra;
    private static List<Cidade> menor_caminho_check;
    private static List<Cidade> menor_caminho_check2;
    private static List<Cidade> menor_caminho_check3;
    private static List<Cidade> menorCaminho;
    
    
    public DijkstraTest() {
        grafo = new Grafo();
        cidade1 = new Cidade("cid1", 0, 0);//feira de santana
        cidade2 = new Cidade("cid2", 40, -30);//simoes filho
        cidade3 = new Cidade("cid3", 50, -30);//camacari
        cidade4 = new Cidade("cid4", 50, -50);//salvador
        cidade5 = new Cidade("cid5", 50, 20);//alagoinhas
        
        aresta1 = new Aresta(cidade1, cidade2, 90);
        aresta2 = new Aresta(cidade1, cidade3, 95);
        aresta3 = new Aresta(cidade2, cidade4, 30);
        aresta4 = new Aresta(cidade2, cidade3, 25);
        aresta5 = new Aresta(cidade2, cidade5, 90);
        aresta6 = new Aresta(cidade1, cidade5, 80);
        aresta7 = new Aresta(cidade2, cidade1, 90);
        aresta8 = new Aresta(cidade3, cidade1, 95);
        aresta9 = new Aresta(cidade3, cidade2, 25);
        aresta10 = new Aresta(cidade4, cidade2, 30);
        aresta11 = new Aresta(cidade5, cidade2, 90);
        aresta12 = new Aresta(cidade5, cidade1, 80);
        
        menor_caminho_check = new ArrayList<Cidade>();
        menor_caminho_check2 = new ArrayList<Cidade>();
        menor_caminho_check3 = new ArrayList<Cidade>();
        menorCaminho = new ArrayList<Cidade>();
        dijkstra = new Dijkstra();
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    /**Test fin_shortest_path com diferentes origens e destinos.
     * 
     */
    @Test
    public void testDijkstra(){
        //adiciona todas as cidades e arestas no grafo
        grafo.add(cidade1);
        grafo.add(cidade2);
        grafo.add(cidade3);
        grafo.add(cidade4);
        grafo.add(cidade5);
        grafo.add(aresta1);
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        
        cidade1.addAresta(aresta1);
        cidade1.addAresta(aresta2);
        cidade1.addAresta(aresta6);
        cidade2.addAresta(aresta3);
        cidade2.addAresta(aresta4);
        cidade2.addAresta(aresta7);
        cidade2.addAresta(aresta5);
        cidade3.addAresta(aresta8);
        cidade3.addAresta(aresta9);
        cidade4.addAresta(aresta10);
        cidade5.addAresta(aresta11);
        cidade5.addAresta(aresta12);
        //executa o Dijkstra com caminhos diferentes e compara a lista retornada com a resposta
        dijkstra = new Dijkstra();
        //adicionando menor caminho em menor_caminho_check
        menor_caminho_check.add(cidade4);
        menor_caminho_check.add(cidade2);
        menor_caminho_check.add(cidade1);
        menorCaminho = dijkstra.find_shortest_path(grafo, cidade1, cidade4);
        assertEquals(menorCaminho, menor_caminho_check);
        //aidicionando menor caminho em menor_caminho_check2
        menor_caminho_check2.add(cidade3);
        menor_caminho_check2.add(cidade1);
        menorCaminho = dijkstra.find_shortest_path(grafo, cidade1, cidade3);
        assertEquals(menorCaminho, menor_caminho_check2);
        //adicionando menor caminho em menor_caminho_check3
        menor_caminho_check3.add(cidade4);
        menor_caminho_check3.add(cidade2);
        menor_caminho_check3.add(cidade3);
        menorCaminho = dijkstra.find_shortest_path(grafo, cidade3, cidade4);
        assertEquals(menorCaminho, menor_caminho_check3);
       
       
    }
}
