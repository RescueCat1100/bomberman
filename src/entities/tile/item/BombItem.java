package entities.tile.item;

import main.*;
import entities.Entity;
import entities.character.Bomber;
import graphics.Sprite;
import sound.Sound;

public class BombItem extends Item {

	public BombItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
            if (e instanceof Bomber) {
                Sound.getClip("ITEM").start();
                Game.addBombRate(1);
                remove();
            }
        return false;
	}

}
