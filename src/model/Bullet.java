package model;

import java.awt.Image;

import manager.ResourceManager;

public class Bullet extends GameObjectDinamic2D {
	public Image image;
        private int attack;
	public Bullet(int x, int y, int width, int height, Image image, int orientation,int attack) {
		super(x, y, width, height, image, orientation);
		 image = ResourceManager.getInstance().getBulletImage();
                 this.attack=attack;
	}
        public int getAttack(){return attack;}
	@Override
	protected void move() {
		switch(orientation){
		case LEFT :
			x = x - 3;
			break;
		case RIGHT:
			x = x + 3;
			break;
		case UP:
			y = y - 3;
			break;			
		case DOWN:
			y = y + 3;
			break;
		}
	}

	public Image getImage() {
		return image;
	}

	
}


