/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballgame;
import com.sun.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.media.opengl.*;
import javax.swing.Timer;

/**
 *
 * @author MARAM
 */
public class theGame {
     public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
 new Menu();
//     
              Scanner scanner = new Scanner(System.in);
        File file = new File("file_example_WAV_2MG.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(10000);
        String response = scanner.next();
   }
    
    public theGame(){
        JFrame j =new JFrame();
        Menu M = new Menu();
        DrawGraphicE e= new DrawGraphicE();
        DrawGraphicM  m= new DrawGraphicM();
        thegameH  h= new thegameH();
   
        
        j.setBounds(10,10,700,600);
         j.setTitle("Bounce Ball");
        j.setVisible(true);
        j.setLayout(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.add(e);
        j.add(m);
        j.add(h);
        j.addKeyListener(e);
        j.addKeyListener(m);
        j.addKeyListener(h);
        j.addMouseMotionListener(e);
        j.addMouseMotionListener(m);
        j.addMouseMotionListener(h);
        
         j.setResizable(false);
        j.setLocationRelativeTo(null);
    }
}

