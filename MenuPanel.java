import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;

public class MenuPanel extends View
{
	public Timer t;
	public static final int MENU_WIDTH = GamePanel.GAME_WIDTH; 
	public static final int MENU_HEIGHT = GamePanel.GAME_HEIGHT; 

	private File fontFile;
	private Font font;
	private Font menuText;
	private Font text;

	


	private ColorText ct;
	private BouncingBall bb;


	public MenuPanel(){
		t =  new Timer(10, this); //repeats actionPerformed every 10 milliseconds 
		setPreferredSize(new Dimension(MENU_WIDTH,MENU_HEIGHT));
		this.addKeyListener(this); //tells GamePanel to listen for keys
		this.setFocusable(true); //sets game as active window
		try{
			fontFile = new File("Square.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			menuText = font.deriveFont(Font.PLAIN, 30);
			text = menuText.deriveFont(20);
			
		}
		catch(FontFormatException e){
		}
		catch(IOException e){
		}
		ct = new ColorText("Awesome Pong", "DIMITRI_.ttf", 80,1000, 0,450);
		
		bb = new BouncingBall();
	}

	public void update(){
		bb.update();

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,MENU_WIDTH,MENU_HEIGHT);
		
		bb.paint(g);
		ct.paint(g);
		g.setFont(menuText);
		g.drawString("Press ENTER to Start",MENU_HEIGHT-137,132); 
		g.setFont(text);
		drawString(g, "You're the left Paddle.\nPress UP or DOWN to Move.", 100,350);
		
		ct.getTimer().start();

		
		
	}

	public void actionPerformed(ActionEvent e){
		update();
		repaint();
	}

	public void drawString(Graphics g, String text, int x, int y) { //overides the drawString method in order to be able to draw multiple lines
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public Timer getTimer(){
		return t;
	}


	public void keyPressed(KeyEvent e){		
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ //checks for up key
			this.setComplete();
		}
		
	}
	
	//Waits for key to be released
	public void keyReleased(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){

	}
}
