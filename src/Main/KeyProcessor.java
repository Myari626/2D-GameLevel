package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX speed = new stopWatchX(90);
    private static int g, h;
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(speed.isTimeUp() == false)			return;
		last = key;
		speed.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case 'w':
			 Main.trigger = "";
                 Main.lastPos.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
                 Main.playerSprite.getCoords().adjustY(-6);
                 Main.playerSprite.setTag("catUp" + h);
                 h = (h + 1) % 4;
             break;
			
		case 'a':
            Main.trigger = "";
                Main.lastPos.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
                Main.playerSprite.getCoords().adjustX(-6);
                Main.playerSprite.setTag("catLeft" + g);
                g = (g + 1) % 4; 
            break;
            
		case 's':
            Main.trigger = "";
                Main.lastPos.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
                Main.playerSprite.getCoords().adjustY(6);
                Main.playerSprite.setTag("catDown" + h);
                h = (h + 1) % 6;
            break;
            
		case 'd':
            Main.trigger = "";
                Main.lastPos.setCoords(Main.playerSprite.getCoords().getX(), Main.playerSprite.getCoords().getY());
                Main.playerSprite.getCoords().adjustX(6);
                Main.playerSprite.setTag("catRight" + g);
                g = (g + 1) % 4;
            break;
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
			
		case '$':
            if (Main.checkCollision(Main.playerBox, Main.couch)) {
                Main.trigger = "I need to take a paws, I'm exhausted. Maybe I should take a nap on the couch.";
            }

            if (Main.checkCollision(Main.playerBox, Main.bowl)) {
                Main.trigger = "You’ve got to be kitten me, where is my food?!";
            }
			break;
		}
	}
}

