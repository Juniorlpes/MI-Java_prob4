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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import util.Aresta;
import util.Cidade;
import util.Grafo;

/**
 * Classe responsável por ler todas as informações do arquivo 
 * de texto que contém os dados do mapa
 * @author juniorlopes
 */
public class ReaderMap {
    private File dirMapa;
    private Grafo grafo;
    /**
     * Construtor que recebe uma string (diretório) para o File e um grafo para armazenar os dados
     * @param dirMapa
     * @param gra 
     */
    public ReaderMap(String dirMapa, Grafo gra) {
        this.dirMapa = new File(dirMapa);
        grafo = gra;
    }
    /**
     * Construtor que recebe um file e um grafo para armazenar os dados
     * @param dirMapa
     * @param gra 
     */
    public ReaderMap(File dirMapa, Grafo gra) {
        this.dirMapa = dirMapa;
        grafo = gra;
    }
    /**
     * Modifica o File para o diretório recebido
     * @param dir 
     */
    public void setDir(String dir){
        this.dirMapa = new File(dir);
    }
    /**
     * Pega as informações do arquivo de texto para colocar no grafo
     * @throws IOException 
     */
    public void importarMapa() throws IOException{
        BufferedReader bufferInpt;
        String linha = "";
        String vetor[];
        Cidade cid, cid1; //duas cidades para construir a arestas
        Aresta aresta, aresta1; //duas arestas para fazer a lista de adj
        try {
            bufferInpt = new BufferedReader(new FileReader(dirMapa));
            
            if(bufferInpt.readLine().equals("Maiores cidades da Bahia")){ //verifica se é o arquivo certo
                linha = bufferInpt.readLine();
                while(! linha.equals("Distancia entre cidades")){                  
                    vetor = linha.split(";");
                    cid = new Cidade(vetor[0],Integer.parseInt(vetor[1].trim()),Integer.parseInt(vetor[2].trim()));
                    grafo.add(cid);
                    linha = bufferInpt.readLine();
                }

                while(bufferInpt.ready()){
                    linha = bufferInpt.readLine();
                    vetor = linha.split(";");
                    
                    cid = grafo.search(vetor[0]);
                    cid1 = grafo.search(vetor[1]);
                    if(cid != null && cid1!= null){
                        aresta = new Aresta(cid,cid1,Integer.parseInt(vetor[2].trim()));
                        aresta1 = new Aresta(cid1,cid,Integer.parseInt(vetor[2].trim()));
                        cid.add(aresta);
                        cid1.add(aresta1);
                        grafo.add(aresta);
                    }
                    
                }              
            } 
        } catch (FileNotFoundException ex) {
            throw ex;
        }             
    }
}
