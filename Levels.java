public class Levels
{
	int l;

	public Levels(){
	}

	public static void newLevel(int level){
		switch(level){
			case 1: GamePanel.getAI().setHeight(90);
					GamePanel.getAI().setVelocity(1);
				break;
			case 2: GamePanel.getAI().setHeight(90);
					GamePanel.getAI().setVelocity(2);
				break;
			case 3: GamePanel.getAI().setHeight(90);
					GamePanel.getAI().setVelocity(3);
				break;
			case 4: GamePanel.getAI().setHeight(110);
					GamePanel.getAI().setVelocity(3);
				break;
			case 5: GamePanel.getAI().setHeight(110);
					GamePanel.getAI().setVelocity(3);
				break;
			case 6: GamePanel.getAI().setHeight(110);
					GamePanel.getAI().setVelocity(4);
				break;
			case 7: GamePanel.getAI().setHeight(130);
					GamePanel.getAI().setVelocity(4);
				break;
			case 8: GamePanel.getAI().setHeight(130);
					GamePanel.getAI().setVelocity(4);
				break;
			case 9: GamePanel.getAI().setHeight(145);
					GamePanel.getAI().setVelocity(5);
				break;
			default: GamePanel.getAI().setHeight(145);
					GamePanel.getAI().setVelocity(5);
		}
	}

}
