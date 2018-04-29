/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 *
 * @author Nirmit Zinzuwadia AND Joel Parikh
 */
public class Game {

    public static final int X_MAX = 600;
    public static final int Y_MAX = 400;
    private Paddle humanPaddle;
    private Paddle computerPaddle;
    private Ball ball;
    private int humanScore = 0;
    private int computerScore = 0;
    
    
     /** Constructor method for the game
    */
    public Game() {
        humanPaddle = new Paddle(0, 155);
        computerPaddle = new Paddle(575, 155);
        ball = new Ball(290, 190);
    }
    

    public void paint(Graphics g) {
        this.ball.paint(g);
        this.computerPaddle.paint(g);
        this.humanPaddle.paint(g);
        Font font = new Font("Arial", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.cyan);
        g.drawString("Human: " + humanScore, 50,380);
        g.drawString("Computer: " + computerScore, 450,380);
       //g.drawImage(black, 0, 0, null);
    }
    
    public void printScore(Graphics g) {
        if (this.ball.getX() < 0) {
            computerScore ++; 
        } else if (this.ball.getX() > 600) { 
            humanScore ++; 
        }       
        g.drawString("Human Player : ", 10, 10);
        g.drawString("" + this.humanScore, 30, 10);
        g.drawString("Computer : ", 40, 10);
        g.drawString("" + this.computerScore, 60, 10);
    }
    
     /** Update method that runs every 5 milliseconds
    * @param change - Represents the change in the ball's position per 5 milliseconds
    */
    public void update(int change){
        // int initialBallPosition = this.ball.getY();
        
        // updating ball
        int computerPaddleRange1 = computerPaddle.getY();
        int computerPaddleRange2 = computerPaddle.getY() + computerPaddle.getLength();
        
        int humanPaddleRange1 = humanPaddle.getY();
        int humanPaddleRange2 = humanPaddle.getY() + humanPaddle.getLength();
        
        int ballRange1 = ball.getY();
        int ballRange2 = ball.getY() + ball.getSize();
        
        if ((ball.getX() + ball.getSize() == 575)) {
             if ((ballRange1 >= computerPaddleRange1) && (ballRange1 <= computerPaddleRange2) || (ballRange2 >= computerPaddleRange1) && (ballRange2 <= computerPaddleRange2)){     
                 ball.setDirectionX(0);  // left
             }
             // else {
             //    ball.setDirectionX(1); //right
               //  humanScore++;
               //  ball.setX(290);
               //  ball.setY(190);
               //  System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
            
        } else if (ball.getX() == 25) {
            if ((ballRange1 >= humanPaddleRange1) && (ballRange1 <= humanPaddleRange2) || (ballRange2 >= humanPaddleRange1) && (ballRange2 <= humanPaddleRange2)) {
                 ball.setDirectionX(1);  // right
            }
            
            /**
             * else {
                ball.setDirectionX(0);  // left   
                computerScore ++;
                ball.setX(290);
                ball.setY(190);
                System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
            }  */         
        } else if (ball.getX() == 600) {
               ball.setDirectionX(1); //right
                 humanScore++;
                 ball.setX(290);
                 ball.setY(190);
                System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
            
        } else if (ball.getX() == -20) {
             ball.setDirectionX(0);  // left   
                computerScore ++;
                ball.setX(290);
                ball.setY(190);
                System.out.println("Computer: " + this.computerScore + " Human: " + this.humanScore);
        }
        
        if (ball.getY() > computerPaddle.getY() + 90 && computerPaddle.getX() < (ball.getX() + 20)) {
            ball.setDirectionY(3);
        } else if (ball.getY() == humanPaddle.getY() + 90 && ball.getX() < (humanPaddle.getX() + 25)) {
            ball.setDirectionY(3);
        } else if (ball.getY() + 20 < computerPaddle.getY() && computerPaddle.getX() < (ball.getX() + 20)) {
            ball.setDirectionY(2);
        } else if (ball.getY() + 20 == humanPaddle.getY() && ball.getX() < (humanPaddle.getX() + 25)) {
            ball.setDirectionY(2);
        }
        
        
        if (ball.getY() + ball.getSize() >= 400) {
           ball.setDirectionY(2);   // up      
        } if (ball.getY() <= 0) {
            ball.setDirectionY(3);  // down
        }
        
        if (this.computerScore < 2 && this.humanScore < 2) {
        if(ball.getDirectionX()== 0){
            ball.setX(ball.getX() - change);
        } else {
            ball.setX(ball.getX() + change);           
        } 
        
        if (ball.getDirectionY() == 2) { 
            ball.setY(ball.getY() - change);
        } else {
            ball.setY(ball.getY() + change); 
        }
        }

//        int computerPaddleRange1 = computerPaddle.getY();
//        int computerPaddleRange2 = computerPaddle.getY() + computerPaddle.getWidth();
//        
//        int humanPaddleRange1 = humanPaddle.getY();
//        int humanPaddleRange2 = humanPaddle.getY() + humanPaddle.getWidth();
//         
//        if (ball.getX() + ball.getSize() >= 575) {
//            ball.setDirectionX(0);  // left          
//        } else if (ball.getX() <= 25) {
//            ball.setDirectionX(1);  // right
//        }
//        
//        if (ball.getY() + ball.getSize() >= 400) {
//           ball.setDirectionY(2);   // up      
//        } if (ball.getY() <= 0) {
//            ball.setDirectionY(3);  // down
//        }
//        
//        if(ball.getDirectionX()== 0){
//            ball.setX(ball.getX() - change);
//        } else {
//            ball.setX(ball.getX() + change);           
//        } 
//        
//        if (ball.getDirectionY() == 2) { 
//            ball.setY(ball.getY() - change);
//        } else {
//            ball.setY(ball.getY() + change); 
//        }
        
      //  this.ball.update(change);        
     //   int finalBallPosition = this.ball.getY();
        
       // int ballDispacement = finalBallPosition - initialBallPosition;
        
        //if (this.ball.getX() > 300) {
        //this.computerPaddle.movePaddle(ballDispacement);
        //}
        
        int ballPosition = this.ball.getY();
        int paddlePosition = this.computerPaddle.getY();
        
        if (this.ball.getX() > 300) {
            if (this.computerPaddle.getY() <= this.ball.getY() + 20 && this.ball.getY() <= this.computerPaddle.getY() + 90) {
            if (this.ball.getDirectionY() == 2) {
                this.computerPaddle.movePaddle((-1)*change);
            } else if (this.ball.getDirectionY() == 3) {
                this.computerPaddle.movePaddle(change);
            }
            } else if (this.computerPaddle.getY() > this.ball.getY() + 20) {
                this.computerPaddle.movePaddle((-1)*change);
            } else if (this.computerPaddle.getY() + 90 < this.ball.getY()) {
                this.computerPaddle.movePaddle(change);
            }
        }
        
    }
    
    /**
     *
     * @param changeY
     */
    public void humanPaddleUpdate(int changeY) {
        this.humanPaddle.movePaddle(changeY);  
    }

    public int getComputerScore() {
        return this.computerScore;
    }

    public int getHumanScore () {
        return this.humanScore;
    }

    public void setComputerScore(int score) {
        this.computerScore = score;
    }

    public void setHumanScore(int score) {
        this.humanScore = score;
    }
    // update method and print score
    // something to stop when a winner is detected
    // computer unbeatable ~ all the time
}
