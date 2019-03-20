/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.Aresta;
import util.Cidade;
import util.Grafo;
import static org.junit.Assert.*;

/**
 *
 * @author João
 */
public class GrafoTest {
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
    
    
    public GrafoTest() {
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
        
    }
    
    
    
    @Before
    public void setUp() {
    }   
    
    

    /**
     * Testa o método de adição (add) de cidades e arestas no grafo.
     */
    @Test
    public void testadd() {
        /*
        ArrayList<Cidade> cidade_test = grafo.getCidades();
        ArrayList<Aresta> aresta_test = grafo.getArestas();
        assertTrue(cidade_test.isEmpty());
        assertTrue(aresta_test.isEmpty());
        //possível código se a classe grafo possuir a função de retornar o array para testes
        //ou poderia haver uma própria função em grafo isEmpty que checa os dois arrays
        */
        grafo.add(cidade1);
        /*assertFalse(grafo.isEmpty());*/
        //adiciona a primeira cidade e checa se o array não está mais vazio
        grafo.add(cidade2);
        grafo.add(cidade3);
        grafo.add(cidade4);
        grafo.add(cidade5);
        
        /*assertEquals(5, cidade_test.size());*/
        
        assertEquals(cidade1, grafo.search("cid1"));
        assertEquals(cidade4, grafo.search("cid4"));
        assertEquals(cidade3, grafo.search("cid3"));
        
        grafo.add(aresta1);
        /*faz a procura de três cidades e adiciona um aresta para checar se influencia de alguma
        forma na busca pela cidade
        */
        assertEquals(cidade2, grafo.search("cid2"));//busca após a inserção de uma aresta
        
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        
        /*assertEquals(6, aresta_test.size());*/
        
        assertEquals(cidade5, grafo.search("cid5"));
        //adiciona o resto das arestas e faz a busca pela última cidade que não havia sido buscada
    }
    /**Testa o método de busca (search) do grafo.
     * sem adicionar nada ao grafo
     */
    @Test
    public void testsearch_empty(){
        /*ArrayList<Cidade> cidade_test = grafo.getCidades();
          ArrayList<Aresta> aresta_test = grafo.getArestas();
        
          assertTrue(cidade_test.isEmpty();
          assertTrue(aresta_test.isEmpty();
        */
        
        assertNull("the city array was supposed to be empty but it isn't", grafo.search("cid1"));
        //tenta buscar por uma cidade sendo que nada foi adicionado
        
        grafo.add(aresta1);
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        
        assertNull("the city array was supposed to be empty but it isn't", grafo.search("cid2"));
    }
    /**Testa o método de busca (search) do grafo.
     * adicionando apenas arestas e não cidades
     */
    @Test
    public void testsearch_arestas_apenas(){
        /*ArrayList<Cidade> cidade_test = grafo.getCidades();
          ArrayList<Aresta> aresta_test = grafo.getArestas();
        
          assertTrue(cidade_test.isEmpty();
          assertTrue(aresta_test.isEmpty();
        */
        
        
        grafo.add(aresta1);
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        //apenas arestas foram adicionadas ao grafo
        assertNull("the city array was supposed to be empty but it isn't", grafo.search("cid2"));
    }
    /**Testa o método de busca (search) do grafo.
     * tenta buscar um item com um nome que não está registrado
     */
    @Test
    public void testsearch_nome_errado(){
        
        grafo.add(cidade1);
        grafo.add(cidade2);
        grafo.add(cidade3);
        grafo.add(cidade4);
        grafo.add(cidade5);
        
        assertNull("the array is not returning what is expected", grafo.search("nome_errado"));
        //o teste de busca e feito primeiro adicionando apenas cidades
        grafo.add(aresta1);
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        //são adicionados vértices para checar se causam alguma interferência na busca
        assertNull("the array is not rturning what is expected", grafo.search("nome_errado"));
    }
    /**Testa o método de busca(search) do grafo.
     * testa a busca adicionando corretamente e pesquisando o nome corretamente
     */
    @Test
    public void testsearch(){
        grafo.add(cidade1);
        grafo.add(cidade2);
        grafo.add(cidade3);
        grafo.add(cidade4);
        grafo.add(cidade5);
        
        assertEquals(cidade1, grafo.search("cid1"));
        assertEquals(cidade4, grafo.search("cid4"));
        assertEquals(cidade3, grafo.search("cid3"));
        assertEquals(cidade2, grafo.search("cid2"));
        assertEquals(cidade5, grafo.search("cid5"));
        //as buscas são realizadas tendo sido adicionados apenas cidades
        grafo.add(aresta1);
        grafo.add(aresta2);
        grafo.add(aresta3);
        grafo.add(aresta4);
        grafo.add(aresta5);
        grafo.add(aresta6);
        
        assertEquals(cidade1, grafo.search("cid1"));
        assertEquals(cidade4, grafo.search("cid4"));
        assertEquals(cidade3, grafo.search("cid3"));
        assertEquals(cidade2, grafo.search("cid2"));
        assertEquals(cidade5, grafo.search("cid5"));
        //as buscas são realizadas após adicionadas as arestas
    }
    
}