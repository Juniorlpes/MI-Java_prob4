/* *****************************************************************************************
*Autor: Nilton Cerqueira Bento de Oliveira Júnior e João Pedro
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
 *Classe para armazenar os dados de uma cidade. (Vértice do Grafo)
 * @author Júnior Lopes e João Pedro
 */
public class Cidade {
    private final String nome;
    private final int posX;
    private final int posY;
    private ArrayList<Aresta> adj;
    private int distancia;
    private Cidade anterior;
    /**
     * Construtor. recebe um nome e sua posição (x,y)
     * @param nome
     * @param posX
     * @param posY 
     */
    public Cidade(String nome, int posX, int posY) {
        this.nome = nome;
        this.posX = posX;
        this.posY = posY;
        adj = new ArrayList<>();
    }
    /**
     * adiciona uma aresta para a lista
     * @param a 
     */
    public void add(Aresta a){
        adj.add(a);
    }
    /**
     * retorna o nome da cidade
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * retorna a posição x
     * @return 
     */
    public int getPosX() {
        return posX;
    }
    /**
     * retorna a posição y
     * @return 
     */
    public int getPosY() {
        return posY;
    }
    /**
     * Verifica se uma cidade recebida é igual a ela
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o){
        return ((Cidade) o).getNome().equals(this.nome);
    }
    
    /**determina a distância da cidade para a cidade de origem escolhida.
     * 
     * @param a valor da distancia
     */
    public void setDistancia(int a){
        this.distancia = a;
    }
    /**retorna a distância da cidade para a cidade de origem.
     * 
     * @return o valor "distancia" da cidade
     */
    public int get_distancia_cidade(){
        return this.distancia;
    }
    /**Retorna uma lista com as cidades adjacentes.
     * 
     * @return uma lista com as cidades adjacentes
     */
    public ArrayList<Aresta> getVizinhos(){
        return this.adj;
    }
    /**atualiza a informação da cidade anterior a esta no menor caminho formado no grafo.
     * 
     * @param cidade cidade anterior no menor camiho
     */
    public void setAnterior(Cidade cidade){
        this.anterior = cidade;
    }
    /**Retorna a cidade anterior no menor caminho do grafo.
     * 
     * @return cidade anterior no menor caminho
     */
    public Cidade getAnterior(){
        return this.anterior;
    }
    
    public void addAresta(Aresta aresta){
        this.adj.add(aresta);
    }
}
