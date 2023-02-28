/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class thegameH extends JPanel implements KeyListener, ActionListener,MouseMotionListener {
    private int score = 0;
    private int bounds=30;
    private int bally=515;
    private int ballx=350;
  //  private boolean move_up,move_left,move_dawn,move_right;
    private Timer timer;
    private int delay =1;
    private int hockx =300;
    //for ball random
    private int ballxd=-3;
    private int ballyd = -5;
    private int totalBricks = 40;
    private boolean play=false;
    private Blocks mapPlay;
    public thegameH()
    {
        mapPlay = new Blocks(5, 10);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){
        
        setBackground(Color.black);
        Graphics2D g1= (Graphics2D) g;
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g3 = (Graphics2D) g;
        Graphics2D g4 = (Graphics2D) g;


        super.paint(g1);

        //Border
        g2.setColor(Color.blue);
        g2.fillRect(0, 0, 3, 592);
        g2.fillRect(0, 0, 692, 3);
        g2.fillRect(690, 0, 3, 592);


        //hock
        g3.setColor(Color.green);
        g3.fillRect(hockx,550,100,8);

        //colored the blocks
        mapPlay.draw((Graphics2D) g, Color.white);

        //ball
        g1.setColor(Color.blue);
        g1.fillOval(ballx,bally,bounds,bounds);

        //score
        g4.setColor(Color.white);
        g4.setFont(new Font("script",Font.BOLD, 25));
        g4.drawString("SCORE"+score, 560,30);

         //won
        if(totalBricks == 0) {
            play = false;
            ballxd = 0;
            ballyd = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("script", Font.BOLD, 30));
            g.drawString("YOU WON,Score: "+score, 260, 300);
        }
        
        
        //Game over
        if(bally > 570)
        {
            play = false;
            ballxd = 0;
            ballyd = 0;
            g.setColor(Color.RED);
            g.setFont(new Font("script",Font.BOLD, 30));
            g.drawString("YOU LOSE ,Your Score:"+score, 150,300);

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_6) {
            if (hockx > 580) {
                hockx =580;
            } else {
                play = true;
                hockx += 10;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_4) {
            if (hockx < 10) {
                hockx = 10;
            } else {
                play = true;
                hockx -= 10;
            }
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (hockx > 580) {
                hockx = 580;
            } else {

                hockx += 10;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (hockx < 10) {
                hockx = 10;
            } else {

                hockx -= 10;
            }
             }
             if (e.getKeyCode() == KeyEvent.VK_P) {
                 play=false ;
             }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            play=true ;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                play = true;
                ballx = 120;
                bally= 350;
                ballxd= -3;
                ballyd= -5;
                hockx = 310;
                score = 0;
                totalBricks = 21;
                mapPlay= new Blocks(4, 9);

                repaint();
            }
        }

        repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play)
        {
            if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(hockx, 550, 30, 8)))
            {
                ballyd = -ballyd;
            }
            else if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(hockx + 70, 550, 30, 8)))
            {
                ballyd = -ballyd;
            }

            else if(new Rectangle(ballx, bally, 20, 20).intersects(new Rectangle(hockx + 30, 550, 40, 8)))
            {
                ballyd = -ballyd;
            }

            // check map collision with the ball
            A: for(int i = 0; i<mapPlay.map.length; i++) 
            {
                for(int j =0; j<mapPlay.map[0].length; j++)
                {
                    if(mapPlay.map[i][j] > 0)
                    {
                        //scores++;
                        int brickX = j * mapPlay.brickWidth + 80;
                        int brickY = i * mapPlay.brickHeight + 50;
                        int brickWidth = mapPlay.brickWidth;
                        int brickHeight = mapPlay.brickHeight;

                        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballx, bally, brickWidth, brickHeight);


                        if(ballRect.intersects(brickRect))
                        {
                            mapPlay.setBrickValue(0, i, j);
                            score+=5;
                            totalBricks--;

                            // when ball hit right or left of brick
                            if(ballx +19  <= brickRect.x || ballx +1  >= brickRect.x + brickRect.width)
                            {
                                ballxd = -ballxd;
                            }
                            // when ball hits top or bottom of brick
                            else
                            {
                                ballyd = -ballyd;
                            }

                            break A;
                        }
                    }
                }
            }

            ballx += ballxd;
            bally += ballyd;

            if(ballx < 0)
            {
                ballxd = -ballxd;
            }
            if(bally < 0)
            {
                ballyd = -ballyd;
            }
            if(ballx > 650)
            {
                ballxd = -ballxd;
            }

            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        double x = e.getX();
        Component c = e.getComponent();
        double width = c.getWidth();
        hockx = (int) ((x / width) * 580);
        repaint();
    }
    
    public int getRandomNumberForY() {
        Random random = new Random();
        int max = -1;
        int min = -6;
        int randomNumber = min + random.nextInt(max - min + 1);
        return randomNumber;
    }

    public int getRandomNumberForX() {
        Random random = new Random();
        int max = -1;
        int min = -3;
        int randomNumber = min + random.nextInt(max - min + 1);
        return randomNumber;
    }
    
}
