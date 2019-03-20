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
package Controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Dijkstra;
import model.ReaderMap;
import model.WriterR;
import util.Aresta;
import util.Cidade;
import util.Grafo;

/**
 * Classe Controller. Gerencia todos os eventos vindo da interface
 * @author Júnior Lopes
 */
public class Controller {
    private Grafo graph;
    private ReaderMap reader;
    private float precoGas = 0 ;
    private float consumo = 0;
    private Vector<String> roteiro;
    private Dijkstra dijkstra = new Dijkstra();
    private WriterR escritor;
    
    /**
     * Construtor. Inicia um Vector para ser o roteiro do usuário
     */
    public Controller() {
        roteiro = new Vector<String>();
        escritor = new WriterR();
    }
    /**
     * retorna o preço da gasolina
     * @return 
     */
    public float getPrecoGas() {
        return precoGas;
    }
    /**
     * Modifica o preço da gasolina
     * @param precoGas 
     */
    public void setPrecoGas(float precoGas) {
        this.precoGas = precoGas;
    }
    /**
     * retorna o consumo do carro
     * @return 
     */
    public float getConsumo() {
        return consumo;
    }
    /**
     * Modifica o consumo do carro
     * @param consumo 
     */
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    /**
     * Método que instancia o ReaderMap, recebe o arquivo escolhido pelo usuário,
     * lê os dados e desenha o mapa na tela
     * @param PanelMap
     * @param lista
     * @param listroteiro 
     */
    public void importMap(JPanel PanelMap, JList lista, JList listroteiro) {                                          
        JFileChooser a = new JFileChooser();
        a.setDialogTitle("Buscar Mapa");
        a.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("texto", "txt");
        a.setFileFilter(filter);
        int retorno = a.showOpenDialog(a); //era this no lugar no a
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            roteiro = new Vector<String>();
            listroteiro.setListData(roteiro);
            File file = a.getSelectedFile();           
            try {
                graph = new Grafo();
                reader = new ReaderMap(file,graph);
                reader.importarMapa();
                colocarCidades(PanelMap.getGraphics(), lista);
                colocarArestas(PanelMap.getGraphics());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler Mapa");
            } 
        }      
    }
    /**
     * Coloca os pontos que representam as cidades no mapa e preenche a Lista 
     * @param g
     * @param lista 
     */
    private void colocarCidades(Graphics g, JList lista){
        int constX = 370;
        int constY=190;
        Vector<String> namesCity = new Vector<String>();
        g.setColor(Color.BLACK);
        Cidade auxCity;
        for(int i = 0; i<graph.getSizeCity(); i++){
            auxCity = graph.getCity(i);
            namesCity.add(auxCity.getNome());
            g.fillOval(constX + auxCity.getPosX(), constY + auxCity.getPosY(), 5, 5);           
            g.drawString(auxCity.getNome(),constX + auxCity.getPosX(),constY + auxCity.getPosY());
        }      
        lista.setListData(namesCity);
    }
    /**
     * Desenha as arestas na tela
     * @param g 
     */
    private void colocarArestas(Graphics g){
        int constX = 370;
        int constY=190;
        Aresta auxAresta;
        for(int i = 0; i<graph.getSizeAresta(); i++){
            auxAresta = graph.getAresta(i);
            g.drawLine(constX+ auxAresta.getCid1().getPosX(),constY+ auxAresta.getCid1().getPosY(), 
                    constX+ auxAresta.getCid2().getPosX(), constY+ auxAresta.getCid2().getPosY());
        }
    }
    /**
     * redesenha o mapa na tela
     * @param g 
     */
    private void repaint(Graphics g){
        int constX = 370;
        int constY=190;
        Cidade auxCity;
        try{
            for(int i = 0; i<graph.getSizeCity(); i++){
                auxCity = graph.getCity(i);
                g.fillOval(constX + auxCity.getPosX(), constY + auxCity.getPosY(), 5, 5);           
                g.drawString(auxCity.getNome(),constX + auxCity.getPosX(),constY + auxCity.getPosY());
            }
        } catch (Exception e) { }
    }
    /**
     * Limpa o roteiro escolhido pelo usuário
     * @param listaRoteiro
     * @param Map 
     */
    public void limparRoteiro(JList<String> listaRoteiro, JPanel Map) {
        roteiro = new Vector<String>();
        listaRoteiro.setListData(roteiro);
        try{
            repaint(Map.getGraphics());    
        } catch (Exception e){        }
    }
    /**
     * Cadastra os dados do consumo e gasolina
     * @param textConsumo
     * @param textGas 
     */
    public void cadastrarDados(JTextField textConsumo, JTextField textGas) {
        if(textConsumo.getText().equals("") || textGas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Valores inválidos no consumo ou gasolina");
        } else{
            try{
                consumo = Float.parseFloat(textConsumo.getText());
                precoGas = Float.parseFloat(textGas.getText());
                JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Valores inválidos no consumo ou gasolina");
            }
        }
    }
    /**
     * adiciona uma cidade ao roteiro
     * @param listaRoteiro
     * @param selectedValue
     * @param map 
     */
    public void addRoteirto(JList<String> listaRoteiro, String selectedValue, JPanel map) {
        try{
            roteiro.add(selectedValue);
            listaRoteiro.setListData(roteiro);
            Cidade aux = graph.search(selectedValue);
            Graphics g = map.getGraphics();
            g.setColor(Color.red);
            g.fillOval(aux.getPosX()+370, aux.getPosY()+190, 4, 4);
        } catch(Exception e) { }
    }
    /**
     * Verifica se o usuário clicou em alguma cidade
     * @param Map
     * @param posXMouse
     * @param posYMouse
     * @param listaRoteiro 
     */
    public void reconhecerCidadeClicada(JPanel Map, int posXMouse, int posYMouse, JList<String> listaRoteiro){
        try{
            Cidade aux;
            Graphics g = Map.getGraphics();
            for(int i = 0; i<graph.getSizeCity(); i++){
                aux = graph.getCity(i);
                //if(aux.getPosX() == posXMouse - 370 && aux.getPosY() == posYMouse - 190){
                if(aux.getPosX() <= posXMouse - 370 && aux.getPosX() >= posXMouse - 375 
                        && aux.getPosY() <= posYMouse - 190 && aux.getPosY() >= posYMouse - 195){
                    g.setColor(Color.red);
                    g.fillOval(aux.getPosX()+370, aux.getPosY()+190, 4, 4);
                    roteiro.add(aux.getNome());
                    listaRoteiro.setListData(roteiro);
                    break;
                }
            }
        } catch (Exception e){ }
    }   
    /**
     * Acha o menor caminho para as cidades em roteiro
     */
    public void acharMenorCaminho(){
        if(precoGas == 0 || consumo == 0){
            JOptionPane.showMessageDialog(null,"Cadastre o preço do combustível e consumo"
                    + " antes de gerar a rota");
        } else{
            try{
                List<Cidade> cidadesrecebida; //as cidades do alg de dijkstra
                ArrayList<Cidade> cidadesroteiro = new ArrayList<>(); //todas do metodo
                ArrayList<Cidade> aux;
                Cidade cid1 = graph.search("Feira de Santana");
                Cidade cid2;
                int distancia = 0;
                for(int i = 0 ; i<=roteiro.size() ; i++){
                    if(i == roteiro.size()){
                        cid2 = graph.search("Feira de Santana");
                        distancia += cid1.get_distancia_cidade();
                    }
                    else
                        cid2 = graph.search(roteiro.get(i));
                    cidadesrecebida = dijkstra.find_shortest_path(graph, cid1, cid2);
                    aux = new ArrayList<>();
                    if(cidadesroteiro.size() == 0){
                        for(Cidade c : cidadesrecebida)
                            aux.add(0, c);       
                        for(Cidade c : aux)
                            cidadesroteiro.add(c);
                    } else {
                        for(Cidade c : cidadesrecebida)
                            aux.add(0,c);
                        for(int j = 1; j<aux.size(); j++)
                            cidadesroteiro.add(aux.get(j));
                    }                                
                    cid1 = cid2;
                }
                escritor.escreverRota(cidadesroteiro, precoGas, consumo, 
                        distancia, graph.search(roteiro.get(roteiro.size()-1)),graph);
                JOptionPane.showMessageDialog(null, "Sua Rota com todas as cidades e"
                        + " detalhes está em um arquivo de texto");
            } catch(Exception e){ }
        }
    }
}
    
