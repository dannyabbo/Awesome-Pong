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
public class ZoomTitle extends View
{

	private String title;
	private File fontFile;
	private Font font;
	private Font awesomeFont;
	private Color titleColor;

	private int x; //relative to center
	private int y; //relative to center

	private Timer timer;

	private int size;
	private int maxSize;


	public ZoomTitle(String t, int maxS,String f,int xPos, int yPos){
		title = t;
		x = xPos;
		y = yPos;
		size = 0;
		maxSize = maxS;
		timer = new Timer(10,this);
		this.addKeyListener(this); //tells GamePanel to listen for keys
		fontFile = new File(f);
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		}
		catch(IOException e){
		}
		catch(FontFormatException e){
		}
		this.setFocusable(true); //sets game as active window
	}

	public void update(){
		size += 1;
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		Font awesomeFont;
		if(size >= maxSize){
			awesomeFont = font.deriveFont(Font.BOLD,maxSize);
		}
		else{
			awesomeFont = font.deriveFont(Font.BOLD,size);
		}
		
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.setFont(awesomeFont);

		FontMetrics fm = g2d.getFontMetrics();
		String s = title;
		
		int w = GamePanel.GAME_WIDTH-x;
		int h = GamePanel.GAME_HEIGHT-y;

		int stringWidth = fm.stringWidth(s);

		drawString(g,s, (w - stringWidth) / 2, h / 2);
	}

	void drawString(Graphics g, String text, int x, int y) { //overides the drawString method in order to be able to draw multiple lines
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public void actionPerformed(ActionEvent e){
		if(size >= maxSize){
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