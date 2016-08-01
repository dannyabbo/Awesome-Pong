//Danny Abbo and Andrew Har
import java.awt.*;
public class  BouncingBall
{
	//sets inititial position
	private int x = GamePanel.GAME_WIDTH/2; 
	private int y = GamePanel.GAME_HEIGHT/2;
	//diameter of ball
	private int diameter = 15; 
	//which side the ball is on
	private boolean onLeft;
	private boolean onRight;

	//tells the ball how many pixels to move per each update
	//first update will move the ball some pixels to the left and up
	//Should be adjusted to increase speed
	private double xVelocity = -3; 
	private double yVelocity = -(Math.ceil((Math.random() *6)));

	private Color color;
	
	//updates ball Position, simmilar to act in grid world
	public void update(){
		x += xVelocity;
		y += yVelocity;

		
		if(y<0 || (y + diameter > GamePanel.GAME_HEIGHT)){ // reverses y position at boundries
			reverseY();
		}
		if (x<0 || (x + diameter > GamePanel.GAME_WIDTH)) { //this reverses the x position at its boundries
			reverseX();
		}
	}

	//Paints the AwesomeBall
	public void paint(Graphics g){ 
		g.setColor(color.WHITE);
		g.fillOval(x,y,diameter,diameter);
	}

	
	//reverses x Direction
	private void reverseX(){
		xVelocity = -(xVelocity);
	}

	//reverses y direction
	private void reverseY(){
		yVelocity = -(yVelocity);
	}


	public void reset(){
		x = GamePanel.GAME_WIDTH/2; 
		y = GamePanel.GAME_HEIGHT/2;
		xVelocity = -3;
		yVelocity = -3;
		onLeft = false;
		onRight = false;

	}

	public void setVelocity(double v){ 
		yVelocity = -v;
	}

	//return x position
	public int getX(){
		return x;
	}

	//return y position
	public int getY(){
		return y;
	}

	//sets the X position
	public void setX(int newX){
		x = newX;
	}

	//sets the Y position
	public void setY(int newY){
		y = newY;
	}
}
