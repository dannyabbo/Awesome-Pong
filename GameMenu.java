import javax.swing.*;
public class GameMenu extends JFrame
{
	public GameMenu(){
		setResizable(false); // doesnt allow player to resize window;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Prevents program from contously running after window closes
		add(new MenuPanel()); // Adds GameMenuPanel to the JFrame
		setSize(MenuPanel.MENU_WIDTH+5,MenuPanel.MENU_HEIGHT+28); //resizes the window to fit all components
		setVisible(true); // Makes window visible
	}
}
