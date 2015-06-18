package ommadawn46.bobblerain;

import processing.core.PVector;

public class Bobble {
	private BobbleRain applet;
	private float x, y, size, r, g, b;
	private PVector speed;

	public Bobble(BobbleRain applet, float x, float y, float size, PVector speed){
		this.applet = applet;
		
		this.x = x;
		this.y = y;
		this.size = size;
		
		// 色のランダム設定
		this.r = (float)(Math.random()*200)+55;
		this.g = (float)(Math.random()*200)+55;
		this.b = (float)(Math.random()*200)+55;
		
		this.speed = speed;
	}

	// ユーザの視点の近くに存在するか
	public boolean isOnField(){
		int width = applet.getSize().width, height = applet.getSize().height;
		PVector basePos = applet.getBasePosition();
		if(Math.sqrt(Math.pow(x+basePos.x-width/2,2) + Math.pow(y+basePos.y-height/2,2)) >
				Math.sqrt(width*width + height*height)){
			return false;
		}
		return true;
	}

	// バブルの描画
	public void update(){
		PVector gravity = applet.getGravity();
		speed.set(speed.x+gravity.x, speed.y+gravity.y);
		x += speed.x * size/50;
		y += speed.y * size/50;
		
		applet.fill(r, g, b, 150);
		applet.ellipse(x, y, size, size);
	}
}
