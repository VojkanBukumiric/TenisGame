package igra;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class IgraOkvir extends JPanel implements Runnable,KeyListener {
	public static final int SIRINA = 600;
	public static final int VISINA = 600;
	
	public static Dimension velicina = new Dimension(SIRINA, VISINA);
	
	public boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	private Tenis tenis;
	

	

	
	public IgraOkvir() {
		setMinimumSize(velicina);
		setPreferredSize(velicina);
		setMaximumSize(velicina);
		
		start();
		
		
	}
	public void start(){
		addKeyListener(this);
		setFocusable(true);
		isRunning = true;
		new Thread(this, "Game Loop").start();
		
	}
	public void stop() {
		isRunning = false;
		System.exit(0);
		
	}
	
	public void run() {
		
		long start;
		long elapsed;
		long wait;
		
		tenis = new Tenis();
		
		
		
		while(isRunning) {
			start = System.nanoTime();
			tick();
			repaint();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed;
			if(wait < 0) wait = 5;
			
			
			try {
				Thread.sleep(wait);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
			
	}
	public void tick() {
		tenis.update();
		
	}
	public void paint(Graphics g) {
		
		
		tenis.draw(g);
		
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		tenis.keyPressed(key);
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		tenis.keyReleased(key);
		
		
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}
}
