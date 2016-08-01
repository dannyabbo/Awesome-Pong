//Danny Abbo and Andrew Har
import java.awt.*;
public class  AwesomeBall
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

		if(x<0 || (x + diameter > GamePanel.GAME_WIDTH)){ // checks if at side boundries
			//checks if scored and which side;
			if(x<0){
				onLeft = true;
				onRight = false;
			} 
			else if( x + diameter > GamePanel.GAME_WIDTH){
				onRight = true;
				onLeft = false;
			}
			else {
				onLeft = false;
				onRight = false;
			}
		}
		if(y<0 || (y + diameter > GamePanel.GAME_HEIGHT)){ // reverses y position at boundries
			reverseY();
		}
	}

	//Paints the AwesomeBall
	public void paint(Graphics g){ 
		g.setColor(color);
		g.fillOval(x,y,diameter,diameter);
	}

	//checks for collision with player, if true will change direction and increas speed
	public void checkCollision(AwesomePlayer player){
		if(this.x >= 0 && this.x <= player.getX() + player.getWidth()){
			if(this.y >= player.getY() && this.y <= player.getY() + player.getHeight()){
					System.out.println("Player Collision" + "\n X Velocity:" + xVelocity + " Y Velocity: " + yVelocity);
					reverseX();
					randomY();
					xVelocity += 0.5;
					GamePanel.setColor(RandomColor.newPrimary());
					color = RandomColor.newSecondary();
					GamePanel.getAI().setColor(RandomColor.newSecondary());
					GamePanel.getAI().setMove(true);
					GamePanel.getPlayer().setColor(RandomColor.newSecondary());
					GamePanel.setScoreColor(RandomColor.newTertiary());
			}
		}
	}
	
	//same as above excepts checks for AI
	public void checkCollision(AwesomeAI cpu){
		if(this.x + diameter >= cpu.getX() && this.x <= GamePanel.GAME_WIDTH){
			if(this.y + diameter >= cpu.getY() && this.y <= cpu.getY() + cpu.getHeight()){
					System.out.println("AI Collision" + " \n X Velocity:" + xVelocity + " Y Velocity: " + yVelocity);
					reverseX();
					randomY();
					xVelocity += -0.5;
					GamePanel.setColor(RandomColor.newPrimary());
					color = RandomColor.newSecondary();
					GamePanel.getAI().setColor(RandomColor.newSecondary());
					GamePanel.getAI().setMove(false);
					GamePanel.getPlayer().setColor(RandomColor.newSecondary());
					GamePanel.setScoreColor(RandomColor.newTertiary());
			}
		}
	}
	
	//reverses x Direction
	private void reverseX(){
		xVelocity = -(xVelocity);
	}

	//reverses y direction
	private void reverseY(){
		yVelocity = -(yVelocity);
	}

	//will reverse the y direction 1/5th of the time
	public void randomY(){
	 int r = (int)(Math.random() * 5) + 1;
		 switch (r){
		 case 1: reverseY(); //reverse direction
			break;
		 case 2: ;
			break;
		 case 3: if(this.x == Math.abs(this.x)){ // increase y velocity by 0.5
					 yVelocity -= 0.5;
				 } else {
					 yVelocity += 0.5;
				 }
			break;
		 case 4: ; //do nothing
			break;
		 case 5: if(this.x == Math.abs(this.x)){ // increase y velocity 
					 yVelocity += 1;
				 } else {
					 yVelocity -= 1;
				 } //do nothing
			break;
		 }
	}

	public void reset(){
		x = GamePanel.GAME_WIDTH/2; 
		y = GamePanel.GAME_HEIGHT/2;
		xVelocity = -3;
		yVelocity = -3;
		onLeft = false;
		onRight = false;

	}

	//returns true if ball is scored on the Left
	public boolean isScoredLeft(){
		return onLeft;
	}

	//returns true if ball is scored on the right
	public boolean isScoredRight(){
		return onRight;
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
