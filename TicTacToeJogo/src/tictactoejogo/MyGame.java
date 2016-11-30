package tictactoejogo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author: Adam Taylor (D3M0L1$3®)
 * @version: 1.0.1.3
 * @release date: 01/29/2010
 * This is a simple Tic-tac-toe game written in Java
 * with some medeokre AI.
 * You go first,
 * can start a new game while in-game, or at the end of game 
 * and it asks
 * @Project Page:https://sourceforge.net/projects/tictactoe-javab/
 * @My Page: http://kickbanned.wordpress.com/
 * */

public class MyGame extends java.awt.Frame {
    private java.awt.MenuBar menuBar1;
    private java.awt.Menu menu1;
    private java.awt.MenuItem menuNewGame;
    private java.awt.MenuItem menuExit;
    private java.awt.MenuItem menuAbout;
    private static JButton button[];    
    private String sign = "X";
    private static String status[] = new String[ 10 ];
    private static String theWinner = "";
    private boolean available = false;
    
    public MyGame() {
        super( "Tic Tac Toe" );
        initComponents();
    }
    
    private void initComponents() {
        setLayout( new java.awt.GridLayout( 3, 3, 1, 1 ) );
        setResizable( false );
        
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menuNewGame = new java.awt.MenuItem();
        menuExit = new java.awt.MenuItem();
        menuAbout = new java.awt.MenuItem();
        
        menu1.setLabel("File");
        menuNewGame.setLabel("New Game");
        menuNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        
        menu1.add(menuNewGame);
        menuExit.setLabel("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        
        menu1.add(menuExit);
        menuAbout.setLabel("About...");
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        
        menu1.add(menuAbout);
        menuBar1.add(menu1);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        
        setMenuBar(menuBar1);
             
        button = new JButton[ 10 ];
        for ( int i = 1; i < 10; i++ ) {
            button[ i ] = new JButton();
            button[ i ].setFocusPainted( false );
            button[ i ].setActionCommand( Integer.toString( i ) );
            button[ i ].setFont( new Font( "Dialog", 0, 48 ) );
            button[ i ].setPreferredSize( new Dimension( 100, 100 ) );
            button[ i ].setToolTipText( "Click to make your move" );
            button[ i ].addActionListener( new ActionListener() {
                public void actionPerformed( ActionEvent evt ) {
                    buttonAction( evt.getActionCommand() ); }
            } );
            add( button[ i ] );
        }     
        pack();
    }
    
    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog( MyGame.this, "This simple game is created by \nD3M0L1SH3R.",
                                        "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE );
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit( 0 );
    }

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {
        setNewGame();
    }

    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit( 0 );
    }
    
    public static void main( String args[] ) {
        new MyGame().show();
        setNewGame();
    }
    
    public void buttonAction( String btn ) {
        int index = Integer.parseInt( btn );
        if ( button[ index ].getText() == "" ) {
            button[ index ].setText( sign );
            status[ index ] = sign;
            checkGameStatus();
            nextMove();
        }
        else
            JOptionPane.showMessageDialog( MyGame.this,
                        "This square is already occupied, \nplease try another one.",
                                            "Oops...", JOptionPane.ERROR_MESSAGE );
    }
    
    public void nextMove() {
        if ( button[ 5 ].getText() == "" ){
            button[ 5 ].setText( "O" );
            status[ 5 ] = "O";
        }
        else {
            int move = randomMove();
            if ( button[ move ].getText() != "" )
                nextMove();
            else {
                button[ move ].setText( "O" );
                status[ move ] = "O";
            }
        }
        
        checkGameStatus();
    }
    
    public String JogoString(){
        if ( available){
        return "";
        }
        else {
        return "Tic Tac Toe";
        }
    }
    
    public Boolean Avaiable(){
        return available;
    }
    
    
    public int randomMove() {
        int attempt = 0;
        if ( available ) {            
            attempt = ( 1 + ( int ) ( Math.random() * 9 ) );        
        }
        return attempt;
    }
    
    public static void setNewGame() {
        for ( int j = 1; j < 10; j++ ) {
            button[ j ].setText( "" );
            status[ j ] = "";            
        }
        theWinner = "";
    }
    
    public int checkGameStatus() {
        
        if ( ( status[ 1 ] != "" ) && ( status[ 1 ] == status [ 2 ] 
            && status[ 2 ] == status[ 3 ] ) ){
            theWinner = status[ 1 ];
            gameStop( theWinner );
        }
        
        if ( ( status[ 4 ] != "" ) && ( status[ 4 ] == status [ 5 ] 
            && status[ 5 ] == status[ 6 ] ) ){
            theWinner = status[ 4 ];
            gameStop( theWinner );
        }
        
        if ( ( status[ 7 ] != "" ) && ( status[ 7 ] == status [ 8 ] 
            && status[ 8 ] == status[ 9 ] ) ){
            theWinner = status[ 7 ];
            gameStop( theWinner );
        }
        
        if ( ( status[ 1 ] != "" ) && ( status[ 1 ] == status [ 4 ] 
            && status[ 4 ] == status[ 7 ] ) ){
            theWinner = status[ 1 ];
            gameStop( theWinner );
        }
        
        if ( ( status[ 2 ] != "" ) && ( status[ 2 ] == status [ 5 ] 
            && status[ 5 ] == status[ 8 ] ) ){
            theWinner = status[ 2 ];
            gameStop( theWinner );
        }
      
        if ( ( status[ 3 ] != "" ) && ( status[ 3 ] == status [ 6 ] 
            && status[ 6 ] == status[ 9 ] ) ){
            theWinner = status[ 3 ];
            gameStop( theWinner );
        }
       
        if ( ( status[ 1 ] != "" ) && ( status[ 1 ] == status [ 5 ] 
            && status[ 5 ] == status[ 9 ] ) ){
            theWinner = status[ 1 ];
            gameStop( theWinner );
        }
        
        if ( ( status[ 3 ] != "" ) && ( status[ 3 ] == status [ 5 ] 
            && status[ 5 ] == status[ 7 ] ) ){
            theWinner = status[ 3 ];
            gameStop( theWinner );
        }
        
        found: {
        for ( int a = 1; a < 10; a++ ) {
            if ( status[ a ] == "" ){
                available = true;
                break found;
            }
            else
                available = false;
        }
        }
        
        if ( !available )
            gameStop( "tie" );
        
        return 0;
    }
    
    public String gameStop( String win ) {
        if ( win == "tie" ){
            JOptionPane.showMessageDialog( MyGame.this, "It's a tie, baby!!! \nLets play again!",
                                        "That was a game...", JOptionPane.INFORMATION_MESSAGE );
            setNewGame();
            return "It's a tie, baby!!! \nLets play again!";
        }
        else {
            String output = "The player \"" + win + "\" has won!!! \nWould you like to play again?";
            int choice = JOptionPane.showConfirmDialog( MyGame.this, output,
                "Congratulations!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );
            if ( choice == 0 )
                setNewGame();
            else
                System.exit( 0 );
            
        }
        return "The player \"" + win + "\" has won!!! \nWould you like to play again?";
    }
    
}

