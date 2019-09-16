package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Loptica {
	
	private int x, y , r;
	private int dx, dy;
	
	
	public Loptica(int x, int y, int r) {
		this.setX(x);
		this.setY(y);
		this.setR(r);
		this.setX(this.getX() - r);
		this.setY(this.getY() - y);
		dx = 2;
		dy = 2;
		
	  }
  public void update () {
	  if(y - r <= 0 ||  y + r >= IgraOkvir.VISINA) dy *= -1;
	  if( x + r >= IgraOkvir.SIRINA) {
		  x = IgraOkvir.SIRINA/2 - r;
		  y = IgraOkvir.VISINA/2 -r;
		  Tenis.igrac1rez +=1;
		  dx *= -1;
		  
	  }
	  if( x - r <= 0) {
		  x = IgraOkvir.SIRINA/2 - r;
		  y = IgraOkvir.VISINA/2 -r;
		  Tenis.igrac2rez +=1;
		  dx *= -1;
		  
	  }
	  x += dx;
	  y += dy;
	
   }
  public void draw(Graphics g) {
	  g.setColor(Color.WHITE);
	  g.fillOval(getX() - getR(), getY() - getR(), getR() * 3, getR() * 3);
	  
  }
  
  public void setDx(int dx) {
	  this.dx = dx;
	  
  }
  public void setDy(int dy) {
	  this.dy = dy;
  }
  public int getDx() {return dx;
  
  }
  public int getDy() {return dy;
  
  }
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getR() {
	return r;
}
public void setR(int r) {
	this.r = r;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}

}
