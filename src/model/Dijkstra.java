/* *****************************************************************************************
*Autor: João Pedro
*Componente Curricular: MI-Programação 
*Concluido em: 05/02/2019
*Declaro que este código foi elaborado por mim de forma individual e não contém nenhum trecho 
*de código de outro colega ou de outro autor, tais como provindos de livros eapostilas, e 
*páginas ou documentos eletrônicos da Internet. Qualquer trecho de códigode outra autoria 
*que não a minha está destacado com uma citação para o autor e a fontedo código, e estou 
*ciente que estes trechos não serão considerados para fins de avaliação.
***************************************************************************************** */
package model;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Cidade;
import util.Grafo;


/**Responsável pela aplicação do algoritmo de Dijkstra.
 *
 * @author João
 */
public class Dijkstra {
    //lista de cidades que constituem o menor caminho
    private List<Cidade> menorCaminho; 
    //lista das cidades que ainda não foram visitadas
    private List<Cidade> naoVisitados; 
    //guarda a cidade que está sendo visitada durante o algoritmo
    private Cidade cidadeAtual;
    //guarda o vizinho da cidade que está sendo visitada pelo algoritmo
    private Cidade vizinho;
    //recebe as cidades que formam o menor caminho
    private Cidade cidadeCaminho;
    
    
    /**Constroi um objeto Dijkstra.
     * 
     */
    public Dijkstra(){
        //menorCaminho = new ArrayList<Cidade>();
        //naoVisitados = new ArrayList<Cidade>();
    }
    
    /**Retorna uma lista com o menor caminho de um ponto a outro no grafo.
     * 
     * @param graph grafo com os vértices e arestas
     * @param cityOrigin cidade que representa o ponto de partida
     * @param destino cidade que representa o ponto de chegada
     * @return lista com o caminho de vertices que formam o menor caminho
     */
    public List<Cidade> find_shortest_path(Grafo graph, Cidade cityOrigin, Cidade destino){
        menorCaminho = new ArrayList<Cidade>();
        naoVisitados = new ArrayList<Cidade>();
        cidadeAtual = null; vizinho = null; cidadeCaminho = null;
        menorCaminho.add(cityOrigin);
        ArrayList<Cidade> arrayCidade = graph.get_city_array();
        /*Os valores "distancia" das cidades serão iniciado. Para a cidade de origem,
        A distância para ela mesma é zero. Para as outras cidades a distrância vai ser 
        iniciada como "inifinito"(maior valor possível na integral)porque ainda não se
        sabe a distância delas para a cidade origem.
         */
        for(Cidade cidade: arrayCidade){
            if(cidade.getNome() == cityOrigin.getNome()){
                cidade.setDistancia(0);
            }
            else{
                cidade.setDistancia(Integer.MAX_VALUE);
            }
            this.naoVisitados.add(cidade);
        }
        Cidade temp;//variável auxiliar 
        /*O array de naoVisitados é ordenado de forma crescente de acordo com o tamanho da distância
        de cada cidade para a de origem.
        */
        Collections.sort(naoVisitados, new Cidadecomparator());
        while(!this.naoVisitados.isEmpty()){
            /*como a lista de não visitados está ordenada, e quando uma cidade for visitada ela é excluída
            da lista de não visitados. Então a primeira posição de naoVisitados vai ser sempre a cidade de 
            menor distância.
            */
            cidadeAtual = this.naoVisitados.get(0);
            //percorre para todos os vizinhos da cidade atual
            for(int i=0; i < cidadeAtual.getVizinhos().size(); i++){
                vizinho = cidadeAtual.getVizinhos().get(i).getCid2();
                if(naoVisitados.contains(vizinho)){
                    /*Se a distância da cidade "vizinho" para a cidade de origem for menor do que a que já está
                    registrada. A distância da cidade "vizinho" é atualizada para o menor valor, e o campo que 
                    contem a cidade anterior a "vizinho" no caminho também é preenchido.                    
                    */
                    if(vizinho.get_distancia_cidade() > (cidadeAtual.get_distancia_cidade() + cidadeAtual.getVizinhos().get(i).getDistancia())){
                        vizinho.setDistancia(cidadeAtual.get_distancia_cidade() + cidadeAtual.getVizinhos().get(i).getDistancia());
                        
                        vizinho.setAnterior(cidadeAtual);
                        /*Se o vizinho for a cidade destino. Então o menor caminho é preenchido recursivamente 
                        com as cidades anteriores ao nó vizinho, que no caso é o destino
                        */
                        if(vizinho.equals(destino)){
                            menorCaminho.clear();
                            cidadeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while(!cidadeCaminho.getAnterior().equals(cityOrigin)){
                                menorCaminho.add(cidadeCaminho.getAnterior());
                                cidadeCaminho = cidadeCaminho.getAnterior();
                            }
                            menorCaminho.add(cityOrigin);
                        }
                    }  
                }
            } 
            naoVisitados.remove(cidadeAtual); 
            //A lista naoVisitados é ordenada novamente, após ser retirada a cidade que já foi visitada 
            Collections.sort(naoVisitados, new Cidadecomparator());
            
        }
        return menorCaminho; 
    }
}