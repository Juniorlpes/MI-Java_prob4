/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestModel;

import java.io.IOException;
import model.ReaderMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Grafo;

/**
 *
 * @author Júnior Lopes
 */
public class GraphTest {
    Grafo graph;
    ReaderMap readerM;
    
    public GraphTest() {
    }
    
    @Before
    public void setUp() {
        graph = new Grafo();
        readerM = new ReaderMap("G:\\Users\\Júnior Lopes\\Desktop\\TESTE_MAP.txt",graph);
    }
    
    @Test
    public void sizeTest() throws IOException{
        readerM.importarMapa();
        assertEquals(2,graph.getSizeCity());
    }
}
