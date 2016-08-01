//Danny Abbo and Andrew Har
import java.awt.*;
public class AwesomePlayer extends AbstractPaddle

{

	private int x = 20;
	private int y = 250; // initial position
	private double yVelocity = 0; //move speed
	private boolean isPlayer = true;
	private int score = 0;
	private static Color color;
	private int level;

	public AwesomePlayer(int l){
		color = Color.WHITE;
		level = l;

	}

	public void update(){
		y+= yVelocity;
	}

	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x,y, getWidth(),getHeight()/level);
	}

	public void reset(){
		y = 250-(getHeight()/2);
		
	}

	public void setVelocity(double v){ 
		yVelocity = -v;
	}

	public boolean isPlayer(){
		return isPlayer;
	}


	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getScore(){
		return super.getScore(score);
	}

	public String getStringScore(){
		return super.getStringScore(score);
	}

	//sets the color
	public  void setColor(Color c){
		color = c;
	}

	public void incrementScore(){
		score++;
	}
}