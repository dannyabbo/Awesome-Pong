//Andrew and Danny
import java.awt.Color;
public class RandomColor
{
	private static Color primary;
	private static int primaryInt;
	private static Color secondary;
	private static Color tertairy;

	

	private static Color red = new Color(178,16,21); //with white
	private static Color jade = new Color(93,214,112); // sand
	private static Color sand = new Color(255,241,39); // with jade
	private static Color cyan = new Color(150,203,255);//with blue
	private static Color blue = new Color(16,0,130);//with cyan
	private static Color pink = new Color(210,149,247);// with grey
	private static Color grey = new Color(81,81,81); //with pink
	private static Color teal = new Color(47,98,255); // with orange
	private static Color orange = new Color(242,116,0); // with teal
	private static Color darkGrey = new Color(50,50,50); // with black


	public RandomColor(){
		primary = Color.BLACK;
		primaryInt = 0;
		secondary = Color.WHITE;
	}

	public static Color newPrimary(){
		boolean choosing = true;
		while(choosing){
			int c = (int)(Math.random() * 7);
			if(c != primaryInt){
				switch(c){
					case 0: primary = Color.BLACK;
							primaryInt = 0;
							choosing = false;
						break;
						
					case 1: primary = red;
							primaryInt = 1;
							choosing = false;
						break;
						
					case 2: primary = teal;
							primaryInt = 2;
							choosing = false;
						break;
						
					case 3: primary = jade;
							primaryInt = 3;
							choosing = false;
						break;
						
					case 4: primary = blue;
							primaryInt = 4;
							choosing = false;
						break;
						
					case 5: primary = grey;
							primaryInt = 5;
							choosing = false;
						break;
						
					case 6: primary = cyan;
							primaryInt = 6;
							choosing = false;
						break;
						
					default: primary = Color.BLACK;
							 primaryInt = 0;
							 choosing = false;
				}
			}
		}
		return primary;
	}

	public static Color newPrimaryWOBlack(){
		boolean choosing = true;
		while(choosing){
			int c = (int)(Math.random() * 6) + 1;
			if(c != primaryInt){
				switch(c){
					case 1: primary = red;
							primaryInt = 1;
							choosing = false;
						break;
						
					case 2: primary = teal;
							primaryInt = 2;
							choosing = false;
						break;
						
					case 3: primary = jade;
							primaryInt = 3;
							choosing = false;
						break;
						
					case 4: primary = blue;
							primaryInt = 4;
							choosing = false;
						break;
						
					case 5: primary = grey;
							primaryInt = 5;
							choosing = false;
						break;
						
					case 6: primary = cyan;
							primaryInt = 6;
							choosing = false;
						break;
						
					default: primary = red;
							 primaryInt = 1;
							 choosing = false;
				}
			}
		}
		return primary;
	}

	public static Color newSecondary(){

		if(primaryInt == 0){
			secondary = Color.WHITE; //black
			return secondary;
		} 
		else if(primaryInt == 1){
			secondary = Color.WHITE; //red
			return secondary;
		}
		else if(primaryInt == 2){
			secondary = orange;
			return secondary;
		}
		else if(primaryInt == 3){
			secondary = sand;
			return secondary;
		}
		else if(primaryInt == 4){
			secondary = cyan;
			return secondary;
		}
		else if(primaryInt == 5){
			secondary = pink;
			return secondary;
		}
		else{
			secondary = Color.WHITE;
			return secondary;
		}
	}

	public static Color newTertiary(){
		if(primaryInt == 0){
			tertairy = darkGrey; //black
			return tertairy;
		} 
		else if(primaryInt == 1){
			tertairy = primary.darker(); //red
			return tertairy;
		}
		else if(primaryInt == 2){
			tertairy = primary.darker();
			return tertairy;
		}
		else if(primaryInt == 3){
			tertairy = primary.darker();
			return tertairy;
		}
		else if(primaryInt == 4){
			tertairy = primary.darker();
			return tertairy;
		}
		else if(primaryInt == 5){
			tertairy = primary.darker();
			return tertairy;
		}
		else{
			tertairy = primary.darker();
			return tertairy;
		}
	}

	public static Color newColor(){
		boolean choosing = true;
		while(choosing){
			int c = (int)(Math.random() * 10) + 1;
			if(c != primaryInt){
				switch(c){
					case 1: primary = red;
							primaryInt = 1;
							choosing = false;
						break;
						
					case 2: primary = teal;
							primaryInt = 2;
							choosing = false;
						break;
						
					case 3: primary = jade;
							primaryInt = 3;
							choosing = false;
						break;
						
					case 4: primary = blue;
							primaryInt = 4;
							choosing = false;
						break;
						
					case 5: primary = grey;
							primaryInt = 5;
							choosing = false;
						break;
						
					case 6: primary = cyan;
							primaryInt = 6;
							choosing = false;
						break;

					case 7: primary = Color.WHITE;
							primaryInt = 7;
							choosing = false;
						break;
					
					case 8: primary = orange;
							primaryInt = 8;
							choosing = false;
						break;
					
					case 9: primary = sand;
							primaryInt = 9;
							choosing = false;
						break;

					case 10: primary = pink;
							primaryInt = 10;
							choosing = false;
						break;
						
					default: primary = red;
							 primaryInt = 9;
							 choosing = false;
				}
			}
		}
		return primary;
	}
}
