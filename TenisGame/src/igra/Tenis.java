package igra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Tenis  {
	
	public Reketi igrac1, igrac2;
	public Loptica loptica;
	
	public static int igrac1rez, igrac2rez; 
	
	
	public Tenis() {
		init();
		
	}
	public void init() {
		igrac1 = new Reketi(new Rectangle(0, IgraOkvir.VISINA/ 2 , 20, 160 ), KeyEvent.VK_W, KeyEvent.VK_S);
		igrac2 = new Reketi(new Rectangle(IgraOkvir.SIRINA -20, IgraOkvir.VISINA / 2, 20,160 ), KeyEvent.VK_UP, KeyEvent.VK_DOWN);
		loptica = new Loptica(IgraOkvir.SIRINA/2,IgraOkvir.VISINA/3, 6);
		igrac1rez = 0;
		igrac2rez = 0;
		
	}
	public void update() {
		igrac1.update(loptica);
	    igrac2.update(loptica);
	    loptica.update();
		
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0 , 0, IgraOkvir.SIRINA, IgraOkvir.VISINA);
		igrac1.draw(g);
		igrac2.draw(g);
		loptica.draw(g);
		
		g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		g.drawString(Integer.toString(igrac1rez), IgraOkvir.VISINA/2 -180,100);
		g.drawString(Integer.toString(igrac2rez), IgraOkvir.SIRINA/2 +120,100);
		
	}
	public void keyPressed(int k) {
		igrac1.keyPressed(k);
		igrac2.keyPressed(k);
		
	}

	public void keyReleased(int k) {
		igrac1.keyReleased(k);
		igrac2.keyReleased(k);
		
	}
	
}

