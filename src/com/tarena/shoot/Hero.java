package com.tarena.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;
public class Hero extends FlyingObject{
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	
	public Hero(){
		image =ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;
		y=400;
		
		life=3;
		doubleFire=0;
		images=new BufferedImage[]{
			ShootGame.hero0,
			ShootGame.hero1	
		};
		index=0;
	
	}
	public void step(){
		image=images[index++/10%images.length];
	}
	
	public Bullet[] shoot(){
		int xStep=ShootGame.WIDTH/9;
		int step=this.width/2;
		if(doubleFire>1){
			Bullet[]bs=new Bullet[9];
			for(int i=0;i<bs.length;i++){
			bs[i]=new Bullet(i*xStep,this.y-20);
			}
			
			doubleFire-=9;
			return bs;
		}else{
			Bullet[]bs=new Bullet[1];
			bs[0]=new Bullet(this.x+step,this.y-20);
			return bs;
		}
	}
	
	public void moveTo(int x,int y){
		this.x=x-this.width/2;
		this.y=y-this.height/2;
	}
	
	public boolean outOfBounds(){
		return false;
	}
	
	public void addLife(){
		life++;
	}
	
	public int getLife(){
		return life;
	}
	
	public void substractLife(){
		life--;
		
		
	}
	
	public void clearDoubleFire(){
		doubleFire=0;
		
	}
	public void addDoubleFire(){
		doubleFire+=100;
	}
	
	public boolean hit(FlyingObject other){
		int x1=other.x-this.width/2;
		int x2=other.x+other.width+this.width/2;
		int y1=other.y-this.height/2;
		int y2=other.y+other.height+this.height/2;
		int x=this.x+this.width/2;
		int y=this.y+this.height/2;
		return(x>=x1&&x<=x2&&y>=y1&&y<=y2);
	}
	
	public int doubleFire(){
		return doubleFire;
	}
	
	}
