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
public class FadeTitle extends View
{

	private String title;
	private File fontFile;
	private Font font;
	private Font awesomeFont;
	private Color titleColor;
	private float alpha;
	private float minAlpha;

	private Timer timer;

	private int size;



	public FadeTitle(String t, float minA,String f, int s){
		title = t;
		size = s;
		alpha = 1;

		minAlpha = minA;
		timer = new Timer(10,this);
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
		alpha-=0.005;
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			
		if(alpha >= minAlpha){
			titleColor = new Color(1,1,1,alpha);
		}
		else {titleColor = new Color(1,1,1,0);
		}
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(titleColor);
		g2d.setFont(awesomeFont);

		FontMetrics fm = g2d.getFontMetrics();
		String s = title;
		
		int w = GamePanel.GAME_WIDTH;
		int h = GamePanel.GAME_HEIGHT-100;

		int stringWidth = fm.stringWidth(s);

		drawString(g,title, (w - stringWidth) / 2, h / 2);
	}

	void drawString(Graphics g, String text, int x, int y) { //overides the drawString method in order to be able to draw multiple lines
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public void actionPerformed(ActionEvent e){
		if(alpha <= minAlpha){
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
