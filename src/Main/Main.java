package Main;

import java.awt.Color; 
import java.util.ArrayList;

import Data.Vector2D;
import Data.boundingBox;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;


public class Main{
	
	public static Color c = new Color(255, 0, 0);
	public static stopWatchX timer = new stopWatchX(3000); 
	public static EZFileRead ezr = new EZFileRead("Text/Keanu.txt"); 
	public static String raw; 
	public static int randInt = 0; 
	public static int tmpInt = 0; 
	public static int frameCounter = 0; 			 				
	
	public static ArrayList<boundingBox> boxes = new ArrayList<>(); 
	public static ArrayList<spriteInfo> sprites = new ArrayList<>(); 
	public static Vector2D currentVec = new Vector2D(630, 650); 	
	public static Vector2D lastVec = new Vector2D(0, 0);
	public static spriteInfo playerSprite = new spriteInfo(currentVec, "catRight"+frameCounter);
	public static spriteInfo lastPos = new spriteInfo (lastVec, playerSprite.getTag()); 
	public static boundingBox playerBox;
	public static boundingBox couch = new boundingBox(340, 788, 365, 618);
	public static boundingBox bowl = new boundingBox(988, 1154, 558, 681);
	
	public static String trigger = "";
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start() {
		boxes.add(new boundingBox(-128, 1408, 0, 128));  
		boxes.add(new boundingBox(-128, 1408, 700, 848));	
		boxes.add(new boundingBox(-128, 0, -128, 848));
		boxes.add(new boundingBox(1280, 1408, -128, 848));

	    boxes.add(new boundingBox(-128, 1408, 128, 130));
	    boxes.add(new boundingBox(-128, 1408, 590, 592));
	    
	    boxes.add(new boundingBox(366, 764, 390, 581)); 
		boxes.add(new boundingBox(1000, 1134, 586, 668)); 
	    sprites.add(new spriteInfo(new Vector2D(0, 0), "room"));
	    sprites.add(playerSprite);
	}

	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	//ctrl.drawString(100, 250, map.get("string"+randInt), Color.BLUE);
	public static void update(Control ctrl) {
		ctrl.drawString(310, 300, trigger, Color.BLUE);
		playerBox = new boundingBox(playerSprite, 20, 108, 108, 120);  	

		for (int i = 0; i < boxes.size(); i++)
			if (checkCollision(playerBox, boxes.get(i)))
				bouncePlayer();
		
		for (int i = 0; i < sprites.size(); i++)
			ctrl.addSpriteToFrontBuffer(sprites.get(i).getCoords().getX(), sprites.get(i).getCoords().getY(), 
					sprites.get(i).getTag());
	}
	
	// Additional Static methods below...(if needed)
	public static void bouncePlayer(){
		if ((playerSprite.getCoords().getX() - lastPos.getCoords().getX()) != 0){
			if ((playerSprite.getCoords().getX() - lastPos.getCoords().getX()) > 0)		
				playerSprite.getCoords().adjustX(-6);								
			if ((playerSprite.getCoords().getX() - lastPos.getCoords().getX()) < 0)  	
				playerSprite.getCoords().adjustX(+6);
		}
		if ((playerSprite.getCoords().getY() - lastPos.getCoords().getY()) != 0){
			if ((playerSprite.getCoords().getY() - lastPos.getCoords().getY()) > 0)		
				playerSprite.getCoords().adjustY(-6);
			if ((playerSprite.getCoords().getY() - lastPos.getCoords().getY()) < 0)		
				playerSprite.getCoords().adjustY(+6);
		}
	
	}	
	public static boolean checkCollision(boundingBox box1, boundingBox box2){
		if (((box1.getX1() > box2.getX2()) 
			|| (box1.getX2() < box2.getX1()) 
			|| (box1.getY1() > box2.getY2()) 
			|| (box1.getY2() < box2.getY1())))
			return false;
		else 
			return true;
		}
} 



