package entities.tile.item;

import main.*;
import entities.Entity;
import entities.character.Bomber;
import graphics.Sprite;
import sound.Sound;

public class FlameItem extends Item {

	public FlameItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn 
            if (e instanceof Bomber) {
                
                Sound.getClip("ITEM").start();
                Game.addBombRadius(1);
                remove();
        }
        return false;
	}
}
