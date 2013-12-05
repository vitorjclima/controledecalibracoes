package br.com.vitorjclima.controledeintervencoes.view;

import java.sql.SQLException;
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
public class LoginTest {
    
    
    public LoginTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of abre_sessao method, of class Login.
     */
    @Test
    public void testAbre_sessao() {
        
        Login instance = new Login();
        assertEquals(true, instance.abre_sessao("natura_vitor", "Pinguim@2013"));
    }

}