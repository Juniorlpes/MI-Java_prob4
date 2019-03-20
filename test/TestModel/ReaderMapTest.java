/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModel;

import java.io.IOException;
import model.ReaderMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Cidade;
import util.Grafo;

/**
 *
 * @author juniorlopes
 */
public class ReaderMapTest {
    public ReaderMap readerM;
    public Grafo graph;
    
    public ReaderMapTest() {
        graph = new Grafo();
        readerM = new ReaderMap("./MapaPBL4.txt",graph);
    }
    
    @Before
    public void setUp() throws IOException {
        readerM.importarMapa();
    }
    
    @Test
    public void testGraph(){
        Cidade a = graph.search("Feira de Santana");
        assertEquals(0,a.getPosX());
    }
    
}
