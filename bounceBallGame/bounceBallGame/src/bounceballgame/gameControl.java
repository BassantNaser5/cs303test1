/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MARAM
 */
public class gameControl  extends JFrame implements  ActionListener{
      JButton k = new JButton("Keyboard");
           JButton m = new JButton("Mouse");
//           gameLevel gL = new gameLevel();
//    
    public gameControl(){
          this.setSize(300,130);
         this.setVisible(true);
         this.setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
         
        JLabel l = new JLabel("Chose game control  : ");
        l.setBounds(100, 5, 130, 30);
          this.add(l); 
         
       
          k.setBounds(30, 60, 100, 25);
         k.addActionListener(this);
         this.add(k);
         
          m.setBounds(180, 60, 80, 25);
         m.addActionListener(this);
         this.add(m);
         
          this.setResizable(false);
         this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//  if(e.getSource()==gL.b&&e.getSource()==k  ){
//            new NewClass();
//            this.dispose(); // it's means give up resources of the frame 
//        }
//   if(e.getSource()==gL.b &&e.getSource()==m ){
//            new NewClass1();
//            this.dispose(); // it's means give up resources of the frame 
//        }
    
    }
}
