package igra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Reketi extends Rectangle{
	private boolean up = false, down = false;
	private int upKey, downKey;

	
	public Reketi(Rectangle r, int upKey, int downKey) {
		setBounds(r);
		y -=(height/2);
		this.upKey = upKey;
		this.downKey = downKey;
		
		
	}
	public void update(Loptica loptica) {
		if(y <= 0) up = false;
		if(y + height >= IgraOkvir.VISINA) down = false;
		if(checkCollision(new Point(loptica.getX() + loptica.getR(), loptica.getY())) || checkCollision(new Point(loptica.getX()- loptica.getR(), loptica.getY()))) {
			loptica.setDx(loptica.getDx()* -1);
		}
		
		if(up) y--;
		if(down)y++;
		
	}
	public boolean checkCollision(Point p) {
		boolean colliding = false;
		if(contains (p)) colliding = true;
		else colliding = false;
		
		return colliding;
		
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
	}
	public void keyPressed(int k) {
		if(k == upKey) up = true;
		if(k == downKey) down = true;
		
	}
	public void keyReleased(int k) {
		if(k == upKey) up = false;
		if(k == downKey) down = false;
		
	}
}
