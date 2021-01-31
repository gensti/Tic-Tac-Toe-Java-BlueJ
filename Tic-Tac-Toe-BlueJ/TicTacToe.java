import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
/**
 * Beschreiben Sie hier die Klasse TicTacToe.
 * 
 * @author (Simon G) 
 * @version (27.01.2021(v21.01.27a3))
 */
public class TicTacToe
{
    //Deklarieren von Variablen
    String xo = "O";
    int[][] gamestorage;
    boolean noWinner = false;
    boolean lastwin = false;
    boolean finishedgame = false;
    //
    JFrame Spielfenster;
    JTextField Infofeld;
    JButton Border1;
    JButton Border2;
    JButton Button11;
    JButton Button12;
    JButton Button13;
    JButton Button21;
    JButton Button22;
    JButton Button23;
    JButton Button31;
    JButton Button32;
    JButton Button33;
    public void start(){
    //Deklarieren des Textfeldes
    Infofeld = new JTextField(50);
    //Deklarieren des Arrays
    gamestorage = new int[3][3];
    //Deklarieren der Buttons
    Button11 = new JButton();
    Button12 = new JButton();
    Button13 = new JButton();
    Button21 = new JButton();
    Button22 = new JButton();
    Button23 = new JButton();
    Button31 = new JButton();
    Button32 = new JButton();
    Button33 = new JButton();
    Border1 = new JButton();
    Border2 = new JButton();
    Border1.setBackground(Color.black);
    Border2.setBackground(Color.black);
   
    
    //Deklariert das Spielfenster
    Spielfenster = new JFrame("TicTacToe");
    Spielfenster.getContentPane().setLayout(new FlowLayout());
    Spielfenster.getContentPane().setLayout(new GridLayout(4,3));
    Spielfenster.getContentPane().add(Button11);
    Spielfenster.getContentPane().add(Button12);
    Spielfenster.getContentPane().add(Button13);
    Spielfenster.getContentPane().add(Button21);
    Spielfenster.getContentPane().add(Button22);
    Spielfenster.getContentPane().add(Button23);
    Spielfenster.getContentPane().add(Button31);
    Spielfenster.getContentPane().add(Button32);
    Spielfenster.getContentPane().add(Button33);
    Spielfenster.getContentPane().add(Border1);
    Spielfenster.getContentPane().add(Infofeld);
    Spielfenster.getContentPane().add(Border2);
    Spielfenster.pack();
    Spielfenster.setVisible(true);
    
    Button11.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(1, 1)){
        Button11.setText(xo);
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button12.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(1, 2)){
        Button12.setText(xo);
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button13.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(1, 3)){
        Button13.setText(xo);
    }
    if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button21.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(2, 1)){
        Button21.setText(xo);
        }
     if(checkGameEnd()){
        finishGame();
        }   
        
         
        
    }
    });
    Button22.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(2, 2)){
        Button22.setText(xo);
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button23.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(2, 3)){
        Button23.setText(xo);
        
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button31.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(3, 1)){
        Button31.setText(xo);
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button32.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(3, 2)){
        Button32.setText(xo);
        }
        
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    Button33.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
     if (handleInput(3, 3)){
        Button33.setText(xo);
        }
        if(checkGameEnd()){
        finishGame();
        }   
    }
    });
    
     


    }
    
    private  boolean handleInput(int x, int y){
        if(finishedgame == false){
        boolean fieldFree = false;
        if (gamestorage[x-1][y-1] == 0){
            if (xo.equals("X")){
                gamestorage[x-1][y-1] = 1;
                xo = "O";
            }else{
                gamestorage[x-1][y-1] = -1;
                xo = "X";
            }
            fieldFree = true;
        }
        return  fieldFree;
    }
       return false;}
    private  boolean checkGameEnd(){

        int usedField = 0;
        for (int x = 0; x<= 2; x++){
            for (int y=0; y<=2; y++){
                usedField = usedField + (Math.abs(gamestorage[x][y]));
            }
        }

        if (usedField == 9 && (Math.abs(gamestorage[0][0] + gamestorage[0][1] + gamestorage[0][2]) == 3
                ||Math.abs(gamestorage[1][0] + gamestorage[1][1] + gamestorage[1][2]) == 3
                ||Math.abs(gamestorage[2][0] + gamestorage[2][1] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][0] + gamestorage[1][0] + gamestorage[2][0]) == 3
                ||Math.abs(gamestorage[0][1] + gamestorage[1][1] + gamestorage[2][1]) == 3
                ||Math.abs(gamestorage[0][2] + gamestorage[1][2] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][0] + gamestorage[1][1] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][2] + gamestorage[1][1] + gamestorage[2][0]) == 3)){
            lastwin = true;
        }

        if (usedField == 9){
            noWinner = true;
        }


        return    (Math.abs(gamestorage[0][0] + gamestorage[0][1] + gamestorage[0][2]) == 3
                ||Math.abs(gamestorage[1][0] + gamestorage[1][1] + gamestorage[1][2]) == 3
                ||Math.abs(gamestorage[2][0] + gamestorage[2][1] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][0] + gamestorage[1][0] + gamestorage[2][0]) == 3
                ||Math.abs(gamestorage[0][1] + gamestorage[1][1] + gamestorage[2][1]) == 3
                ||Math.abs(gamestorage[0][2] + gamestorage[1][2] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][0] + gamestorage[1][1] + gamestorage[2][2]) == 3
                ||Math.abs(gamestorage[0][2] + gamestorage[1][1] + gamestorage[2][0]) == 3)
                || lastwin
                || noWinner;
    
    
    
            }
        
        private  void  finishGame(){
            
            if(finishedgame == false){
                finishedgame = true;
        if (noWinner != lastwin){
            Infofeld.setText("The Game ended - No Winner");
            
        }
       else if (xo.equals("X")){
            Infofeld.setText("X has won!");
            
        }else{
            Infofeld.setText("O has won!");
        } }


    }}
    
