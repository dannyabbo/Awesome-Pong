import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public class FlashTitle extends View
{

	private String title;
	private File fontFile;
	private Font font;
	private Font awesomeFont;
	private Color titleColor;

	private Timer timer;

	private int size;

	private boolean switchFlash;
	private int numFlash;
	int currentFlash;



	public FlashTitle(String t, int interval,String f, int s, int n){
		title = t;
		size = s;
		numFlash = n;
		switchFlash = false;
		currentFlash = 1;
		timer = new Timer(interval,this);
		this.addKeyListener(this); //tells GamePanel to listen for keys
		fontFile = new File(f);
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			awesomeFont = font.deriveFont(Font.PLAIN,size);
		}
		catch(IOException e){
		}
		catch(FontFormatException e){
		}
		this.setFocusable(true); //sets game as active window
	}

	public void update(){
		if(switchFlash){
			switchFlash = false;
		}
		else{
			switchFlash = true;
			currentFlash++;
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			
		titleColor = new Color(1,1,1,1);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(titleColor);
		g2d.setFont(awesomeFont);

		FontMetrics fm = g2d.getFontMetrics();
		String s = title;
		
		int w = GamePanel.GAME_WIDTH;
		int h = GamePanel.GAME_HEIGHT-100;

		int stringWidth = fm.stringWidth(s);
		if(switchFlash){
			drawString(g2d,title, (w - stringWidth) / 2, h / 2);
		}
		else{
			g.setColor(Color.BLACK);
			g.fillRect(0,0,GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		}

		
	}

	void drawString(Graphics g, String text, int x, int y) { //overides the drawString method in order to be able to draw multiple lines
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public void actionPerformed(ActionEvent e){
		//count how many flashes then complete
		if(currentFlash == numFlash){
			this.setComplete();
		}
		update();
		repaint();
		
	}

	public Timer getTimer(){
		return timer;
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP){ //checks for up key
			this.setComplete();
		}
		

	}
	
	//Waits for key to be released
	public void keyReleased(KeyEvent e){
	
	}
	
	public void keyTyped(KeyEvent e){

	}


}