import java.awt.*;
//Danny Abbo and Andrew Har
public abstract class AbstractPaddle
{
	private int x;
	private int y;
	private int score;
	private int width = 10;
	private int height = 90;
	

	//returns the width of paddle
	public int getWidth(){
		return width;
	}

	//returns the height of paddle
	public int getHeight(){
		return height;
	}

	//paints the Player Paddle
	public abstract void paint(Graphics g);

	//updates ball Position, simmilar to act in grid world
	public abstract void update();

	//set the speed of the paddle
	public abstract void setVelocity(double v);

	//returns x position
	public abstract int getX();

	//returns y position
	public abstract int getY();

	//sets the X position
	public void setX(int newX){
		x = newX;
	}

	//sets the Y position
	public void setY(int newY){
		y = newY;
	}

	//sets the height of the paddle
	public void setHeight(int h){
		height = h;
	}

	//returns if its the player or AI
	public abstract boolean isPlayer();

	//returns the score
	public int getScore(int s){
		score = s;
		return score;
	}

	//returns the score as a String
	public String getStringScore(int s){
		score = s;
		String x = "" + s;
		return x;
	}

	public abstract void setColor(Color c);

	
}
