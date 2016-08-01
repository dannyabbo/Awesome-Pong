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
public class ColorText implements ActionListener
{

	private String title;
	private int x; //relative to center
	private int y; //relative to center
	private int size;
	private File fontFile;
	private Font font;
	private Font awesomeFont;
	private Timer timer;
	private Color color;

	public ColorText(String t, String f, int s, int mil, int xPos, int yPos){
		title = t;
		size = s;
		x = xPos;
		y = yPos;
		color = Color.WHITE;
		timer = new Timer(mil, this);
		timer.setInitialDelay(2000); //waits three seconds before starting
		fontFile = new File(f);
		try{
			font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		}
		catch(IOException e){
		}
		catch(FontFormatException e){
		}
		awesomeFont = font.deriveFont(Font.BOLD,size);
	}

	public void update(){
		color = RandomColor.newColor();
	}

	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		g2d.setFont(awesomeFont);
		FontMetrics fm = g2d.getFontMetrics();
		int w = GamePanel.GAME_WIDTH-x;
		int h = GamePanel.GAME_HEIGHT-y;
		int stringWidth = fm.stringWidth(title);
		drawString(g,title, (w - stringWidth) / 2, h / 2);
	}

	public void actionPerformed(ActionEvent e){
		update();
	}

	void drawString(Graphics g, String text, int x, int y) { //overides the drawString method in order to be able to draw multiple lines
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}

	public Timer getTimer(){
		return timer;
	}


}
