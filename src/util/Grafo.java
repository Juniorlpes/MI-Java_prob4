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
package util;

import java.util.ArrayList;


/**
 * Classe para o grafo (estrutura de dados).
 * Ela guarda a lista de cidades e arestas existentes
 * @author Júnior Lopes
 */
public class Grafo {
    private ArrayList<Cidade> cidades;
    private ArrayList<Aresta> arestas;
    /**
     * Construtor. inicia as listas de cidades e arestas
     */
    public Grafo() {
        cidades = new ArrayList<Cidade>();
        arestas = new ArrayList<Aresta>();
    }
    /**
     * retorna a quantidade de cidades
     * @return 
     */
    public int getSizeCity(){
        return cidades.size();
    }
    /**
     * retorna a quantidade de arestas
     * @return 
     */
    public int getSizeAresta(){
        return arestas.size();
    }
    /**
     * retorna uma cidade pela posição
     * @param pos
     * @return 
     */
    public Cidade getCity(int pos){
        return cidades.get(pos);
    }
    /**
     * retorna uma aresta pela posição
     * @param pos
     * @return 
     */
    public Aresta getAresta(int pos){
        return arestas.get(pos);
    }
    /**
     * adiciona uma cidade ou uma aresta no grafo
     * @param o 
     */
    public void add(Object o){
        if(o instanceof Cidade)
            cidades.add((Cidade) o);
        else if(o instanceof Aresta)
            arestas.add((Aresta) o);
    }
    /**
     * procura uma cidade no grafo dado o nome
     * @param nome
     * @return 
     */
    public Cidade search(String nome){
        Cidade a;
        for(int i = 0; i<cidades.size(); i++){
            a = (Cidade)cidades.get(i);
            if(a.getNome().toLowerCase().trim().equals(nome.toLowerCase().trim()))
                return a;
        }
        return null;
    }
    
    public ArrayList<Cidade> get_city_array(){
        return cidades;
    }
    
}
