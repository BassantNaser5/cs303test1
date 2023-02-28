/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MARAM
 */
public  class gameLevel extends JFrame implements ActionListener {
    public String playerName;
    public int score;

     JButton e = new JButton("Easy");
        JButton m = new JButton("Medium ");
            JButton h = new JButton("Hard");
            
  public  gameLevel(){
       super("Level gameplay :");
         this.setSize(330,130);
         this.setVisible(true);
         this.setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
           
        JLabel l = new JLabel("Chose game level  : ");
        l.setBounds(20, 5, 130, 30);
          this.add(l); 
          
     
          e.setBounds(10, 60, 80, 25);
          e.setBackground(Color.green);
         e.addActionListener(this);
         this.add(e);
         
       
         m.setBounds(110, 60, 100, 25);
         m.setBackground(Color.yellow);
         m.addActionListener(this);
         this.add(m);
         
      
          h.setBounds(230, 60, 80, 25);
          h.setBackground(Color.red);
         h.addActionListener(this);
         this.add(h);
         
         e.addActionListener(this);
       m.addActionListener(this);
       h.addActionListener(this);
       
          this.setResizable(false);
         this.setLocationRelativeTo(null);
  }

    @Override
    public void actionPerformed(ActionEvent ea) {
 if(ea.getSource()==e){
            new DrawGraphicE();
            this.dispose(); // it's means give up resources of the frame 
        }
if(ea.getSource()==m){
            new DrawGraphicM();
            this.dispose(); // it's means give up resources of the frame 
      }
//if(ea.getSource()==h){
//            new DrawGraphicH();
//            this.dispose(); // it's means give up resources of the frame 
//        }
//    }

}
}