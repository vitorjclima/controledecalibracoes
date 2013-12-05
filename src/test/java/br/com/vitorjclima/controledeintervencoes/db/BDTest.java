package br.com.vitorjclima.controledeintervencoes.db;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class BDTest {
    BD instance;
    
    
    
    public BDTest() {
        instance = new BD();        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        testSet_login();
        testConecta_BD();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of set_login method, of class BD.
     */
    @Test
    public void testSet_login() {
        instance.set_login("natura_vitor","Pinguim@2013");
        assertEquals("natura_vitor", instance.getLogin());
        assertEquals("Pinguim@2013", instance.getSenha());
    }
    

    /**
     * Test of conecta_BD method, of class BD.
     */
    @Test
    public void testConecta_BD() throws Exception {
        System.out.println("conecta_BD");
        instance.conecta_BD();
        assertEquals(false, instance.getConexao().isClosed());
    }

    /**
     * Test of close method, of class BD.
     */
    @Test
    public void testClose() {
        
        assertEquals(true,instance.close() );
        
    }
}