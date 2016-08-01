import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.io.*;
public abstract class View extends JPanel  implements ActionListener, KeyListener{

	boolean complete;
	
	public View(){
		complete = false;
	}

	public void setComplete(){
		complete = true;
	}

	public boolean isComplete(){
		return complete;
	}

	public abstract Timer getTimer();

}
