//Danny Abbo and Andrew Har
import java.awt.*;
public class AwesomeAI extends AbstractPaddle
{
	
	private int x = GamePanel.GAME_WIDTH - (20 + getWidth());
	private int y = 250; // initial position
	private double yVelocity = -3; //move speed
	private boolean isPlayer = false;
	private int score = 0;
	private static Color color;
	private boolean move = false;

	public AwesomeAI(){
		color = Color.WHITE;
	}

	public void update(){
		
		if(move){
			if(GamePanel.getBall().getY() < this.y + getHeight()/2){
				//ball is above AI
				y += yVelocity;
			}
			else if(GamePanel.getBall().getY() > this.y + getHeight()/2){
				//ball is below AI
				y -= yVelocity;
				
			}
		}
	}

	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x,y, getWidth(),getHeight());
	}

	public void reset(){
		y = 250-(getHeight()/2);
	}

	public boolean isPlayer(){
		return isPlayer;
	}

	public void setVelocity(double v){ 
		yVelocity = -v;
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
	public void setColor(Color c){
		color = c;
	}

	public void incrementScore(){
		score++;
	}

	public void setMove(boolean m){
		move = m;
	}

}
