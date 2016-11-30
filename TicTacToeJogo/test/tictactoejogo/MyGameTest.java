/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoejogo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique
 */
public class MyGameTest {
    
    public MyGameTest() {
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
     * Test of main method, of class MyGame.
     */
    @Test
    public void testMain() {
        
    }

    /**
     * Test of buttonAction method, of class MyGame.
     */
    @Test
    public void testButtonAction() {
    }

    /**
     * Test of nextMove method, of class MyGame.
     */
    @Test
    public void testNextMove() {
        
    }
    
    public void testAvailable(){
        MyGame instance = new MyGame();
        boolean result = instance.Avaiable();
        assertFalse(result);
    }

    /**
     * Test of pessoa method, of class MyGame.
     * MyGame instance = new MyGame();
        String expResult = "tictactoe";
        String result = instance.JogoString();
        assertEquals(expResult, result);
     */
    @Test
    public void testJogoString() {
        MyGame instance = new MyGame();
        String expResult = "Tic Tac Toe";
        String result = instance.JogoString();
        assertEquals(expResult, result);
    }

    /**
     * Test of randomMove method, of class MyGame.
     */
    @Test
    public void testRandomMove() {
        MyGame instance = new MyGame();
        int expResult = 0;
        int result = instance.randomMove();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNewGame method, of class MyGame.
     */
    @Test
    public void testSetNewGame() {
        
    }

    /**
     * Test of checkGameStatus method, of class MyGame.
     */
    @Test
    public void testCheckGameStatus() {
       MyGame instance = new MyGame();
        int result = instance.checkGameStatus();
        assertNotNull(result);
    }
   
    
    

    /**
     * Test of gameStop method, of class MyGame.
     */
    @Test
    public void testGameStop() {
        MyGame instance = new MyGame();
        String expResult = "It's a tie, baby!!! \nLets play again!";
        String result = instance.gameStop("tie");
        assertEquals(expResult, result);
    }
}