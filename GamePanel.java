//Danny Abbo and Andrew Har
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public class  GamePanel extends View
{
	public static Timer t;
	public static final int GAME_WIDTH = 800; 
	public static final int GAME_HEIGHT = 500; 

	private JPanel contentPane;

	private static AwesomePlayer p;
	private static AwesomeAI ai;
	private static AwesomeBall ball;
	
	private static Color color;
	private static Color scoreColor = RandomColor.newTertiary();

	private File fontFile;
	private File fontFile2;
	private Font font;
	private Font scoreFont;
	private Font winnerFont;
	private boolean playerWin;
	private boolean aiWin;
	
	public GamePanel(int l){
		t =  new Timer(10, this); //repeats actionPerformed every 10 milliseconds
		t.setInitialDelay(3000); //waits three seconds before starting
		setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
		this.addKeyListener(this); //tells GamePanel to listen for keys
		this.setFocusable(true); //sets game as active window
		color = Color.BLACK;
		p = new AwesomePlayer(l);
		ai = new AwesomeAI();
		ball = new AwesomeBall();
		playerWin = false;
		aiWin = false;
		try{
			fontFile = new File("ProgFont.ttf");
			fontFile2 = new File("Square.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			scoreFont = font.deriveFont(Font.BOLD,GAME_HEIGHT-100);
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile2);
			winnerFont = font.deriveFont(Font.BOLD,GAME_HEIGHT-350);
			
		}
		catch(FontFormatException e){
		}
		catch(IOException e){
		}
		
	}

	//updates the current state of game
	private void update(){ 
		p.update();
		ball.update();
		ball.checkCollision(p);
		ball.checkCollision(ai);
		ai.update();
		updateScore();
		if(ball.isScoredLeft()){
			reset();
		}
		else if(ball.isScoredRight()){	
			reset();
		}
	}

	//Overides JPanels Method
	public void paintComponent(Graphics g){

		//main
		super.paintComponent(g);
		g.setColor(color);
		g.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);

		//scoring
		g.setColor(scoreColor);
		g.setFont(scoreFont);
		if(ai.getScore() > 9){
			g.setFont(winnerFont);
			g.drawString("WIN", (GAME_WIDTH/2)+55,290);
			g.setFont(scoreFont);
			aiWin=true;
			playerWin=false;
			this.setComplete();
		} else{
			g.drawString(ai.getStringScore(), (GAME_WIDTH/2)+88,GAME_HEIGHT-105);
			aiWin=false;
			playerWin=false;
		}
		if(p.getScore() > 9){
			g.setFont(winnerFont);
			g.drawString("WIN", 55,290);
			g.setFont(scoreFont);
			aiWin=true;
			playerWin=false;
			this.setComplete();
		} else{
			g.drawString(p.getStringScore(),88,GAME_HEIGHT-105);
			aiWin=false;
			playerWin=false;
		}		

		//Game Compoenents
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		p.paint(g);
		ai.paint(g);
		ball.paint(g);
	}

	// THE GAME LOOP
	public void actionPerformed(ActionEvent e){ 
		update();
		repaint();//repaints everything with new information
	}

	//Resets all positions
	public void reset(){
		
		p.reset();
		ai.reset();
		ball.reset();
		
		try{
			//Thread.sleep(3000);
			t.start();
		}
		catch(Exception e){
		}
		
	}
	
	//retuns the ball
	public static AwesomeBall getBall(){
		return ball;
	}

	//returns the AI
	public static AwesomeAI getAI(){
		return ai;
	}

	//returns the the player
	public static AwesomePlayer getPlayer(){
		return p;
	}

	//set the primary color
	public static void setColor(Color c){
		color = c;
	}

	public boolean playerWon(){
		return playerWin;
	}

	public boolean aiWon(){
		return aiWin;
	}

	public static Color getColor(){
		return color;
	}

	public Timer getTimer(){
		return t;
	}

	public static void setScoreColor(Color c){
		scoreColor = c;
	}

	//update the scores of both sides
	public void updateScore(){
		if(ball.isScoredLeft()){
			t.stop();
			ai.incrementScore();
			System.out.println("ai scored: " + ai.getScore());
			
		}
		else if(ball.isScoredRight()){
			t.stop();
			p.incrementScore();
			System.out.println("player scored: " + p.getScore());
			
		}
	}

	//Waits for key to be Pressed
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP && p.getX() > 0){ //checks for up key
			p.setVelocity(6); //moves the paddle up
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN && p.getX() < GAME_HEIGHT){ //checks for up key
			p.setVelocity(-6); //moves the paddle up
		}

	}
	
	//Waits for key to be released
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){ //checks for up key
			p.setVelocity(0); //stops the paddle
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){ //checks for up key
			p.setVelocity(0); //moves the paddle up
		}
	}
	
	public void keyTyped(KeyEvent e){

	}
}
