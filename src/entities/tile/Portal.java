package entities.tile;

import main.*;
import entities.Entity;
import entities.character.Bomber;
import graphics.Sprite;
import sound.Sound;

public class Portal extends Tile {
        protected Board _board;
	public Portal(int x, int y,Board board, Sprite sprite) {
		super(x, y, sprite);
                _board = board;
	}
	
	@Override
	public boolean collide(Entity e) {//xu li khi 2 entity va cham
                                          //true cho di qua
                                          //false khong cho di qua
		// TODO: xử lý khi Bomber đi vào
                if(e instanceof Bomber ) {
			
			if(_board.detectNoEnemies() == false)
				return false;
			
			if(e.getXTile() == getX() && e.getYTile() == getY()) {
				if(_board.detectNoEnemies()){
					_board.nextLevel();
                    Sound.getClip("NEXT_LV").start();
                    }
			}
			
			return true;
		}
		
		return true;
	}

}
