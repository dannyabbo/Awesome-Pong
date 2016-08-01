//Danny Abbo and Andrew Har
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PongFrame extends JFrame implements ActionListener
{
	Timer timer;

	private int currentView = 1;

	private FadeTitle ft;
	private FadeTitle ft1;
	private FadeTitle ft2;
	private ZoomTitle zt;
	private MenuPanel menu;
	private GamePanel game;
	private FlashTitle winner;
	View view;
	
	public PongFrame(){
		setTitle("Awesome Pong");
		initialize();
		timer = new Timer(10,this);
		timer.start();
		setResizable(false); // doesnt allow player to resize window;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Prevents program from contously running after window closes
		setSize(GamePanel.GAME_WIDTH+5,GamePanel.GAME_HEIGHT+28); //resizes the window to fit all components
		setLocationRelativeTo(null); 
		setVisible(true); // Makes window visible
		
	}

	public void initialize(){
		ft = new FadeTitle("Danny Abbo", 0, "emulogic.ttf", 50);
		ft1 = new FadeTitle("Andrew Har", 0, "emulogic.ttf", 50);
		ft2 = new FadeTitle("Presents", 0, "emulogic.ttf", 50);
		zt = new ZoomTitle("Awesome Pong",80,"DIMITRI_.ttf",0,450);
		menu = new MenuPanel();
		game = new GamePanel(1);
	}

	public void display(){
		if(currentView == 1){
			
			getContentPane().add(ft);
			getContentPane().validate();
			ft.getTimer().start();
			ft.requestFocus();
			if(ft.isComplete()){
				ft.getTimer().stop();
				System.out.println("complete");

				incrementView();
			}
		}
		else if(currentView == 2){
			
			getContentPane().remove(ft);
			getContentPane().invalidate();
			getContentPane().add(ft1);
			getContentPane().validate();
			ft1.getTimer().start();
			ft1.requestFocus();
			if(ft1.isComplete()){
				ft1.getTimer().stop();
				System.out.println("complete");

				incrementView();

			}
		}
		else if(currentView == 3){
			getContentPane().remove(ft1);
			getContentPane().invalidate();
			getContentPane().add(ft2);
			getContentPane().validate();
			ft2.getTimer().start();
			ft2.requestFocus();
			if(ft2.isComplete()){
				ft2.getTimer().stop();
				
				incrementView();

			}
		}
		else if(currentView == 4){
			
			getContentPane().remove(ft2);
			getContentPane().invalidate();
			getContentPane().add(zt);
			getContentPane().validate();
			zt.getTimer().start();
			zt.requestFocus();
			if(zt.isComplete()){
				zt.getTimer().stop();
				
				incrementView();

			}
		}
		else if(currentView == 5){
			
			getContentPane().remove(zt);
			getContentPane().invalidate();
			getContentPane().add(menu);
			getContentPane().validate();
			menu.getTimer().start();
			menu.requestFocus();
			if(menu.isComplete()){
				menu.getTimer().stop();
				
				incrementView();

			}
		}
		else if(currentView == 6){
			getContentPane().remove(menu);
			getContentPane().invalidate();
			getContentPane().add(game);
			getContentPane().validate();
			game.getTimer().start();
			game.requestFocus();
			if(game.isComplete()){
				game.getTimer().stop();
				getContentPane().remove(view);
				getContentPane().invalidate();
				setView(5);

			}
		}
	}

	public void setView(int v){
		currentView = v;
	}

	public  void incrementView(){
		currentView++;
	}

	public void actionPerformed(ActionEvent e){
		display();
	}
}