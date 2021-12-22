package entities.bomb;

import javax.sound.sampled.Clip;

import main.*;
import entities.AnimatedEntitiy;
import entities.Entity;
import entities.character.Bomber;
import graphics.Screen;
import graphics.Sprite;
import entities.character.Character;
import level.Coordinates;
import sound.Sound;
public class Bomb extends AnimatedEntitiy {

	protected double _timeToExplode = 200; //thoi gian phat no
	public int _timeAfter = 15; // thoi gian hieu ung no 
	
	protected Board _board;
	protected Flame[] _flames;
	protected boolean _exploded = false;
	protected boolean _allowedToPassThru = true;
	 
	public Bomb(int x, int y, Board board) {
		_x = x;
		_y = y;
		_board = board;
		_sprite = Sprite.bomb;
	}
	
	@Override
	public void update() {
		if(_timeToExplode >= 0) 
			_timeToExplode--;
		else {
			if(!_exploded) 
				explode();
			else
				updateFlames();
			
			if(_timeAfter > 0) 
				_timeAfter--;
			else
				remove();
		}
			
		animate();
	}
	
	@Override
	public void render(Screen screen) {
		if(_exploded) {
			_sprite =  Sprite.bomb_exploded2;
			renderFlames(screen);
		} else
			_sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
		
		int xt = (int)_x << 4;
		int yt = (int)_y << 4;
		
		screen.renderEntity(xt, yt , this);
	}
	
	public void renderFlames(Screen screen) {
		for (int i = 0; i < _flames.length; i++) {
			_flames[i].render(screen);
		}
	}
	
	public void updateFlames() {
		for (int i = 0; i < _flames.length; i++) {
			_flames[i].update();
		}
	}

    /**
     * Xử lý Bomb nổ
     */
	protected void explode() {
		_exploded = true;
		_allowedToPassThru = true;
		
		Character x = _board.getCharacterAtExcluding((int)_x, (int)_y, null);
                if(x != null){
                    x.kill();
                }
		
                _flames = new Flame[4];
                for (int i = 0; i < _flames.length; i++) {
                    _flames[i] = new Flame((int) _x, (int) _y, i, Game.getBombRadius(), _board);
                }
				Clip clip = Sound.getClip("BOM_EXP");
				clip.start();
	}
        public void time_explode() {
		_timeToExplode = 0;
	}
	public FlameSegment flameAt(int x, int y) {
		if(!_exploded) return null;
		
		for (int i = 0; i < _flames.length; i++) {
			if(_flames[i] == null) return null;
			FlameSegment e = _flames[i].flameSegmentAt(x, y);
			if(e != null) return e;
		}
		
		return null;
	}

	@Override
	public boolean collide(Entity e) {
        // TODO: xử lý khi Bomber đi ra sau khi vừa đặt bom (_allowedToPassThru)
        
        if(e instanceof Bomber) {
			double diffX = e.getX() - Coordinates.tileToPixel(getX());
			double diffY = e.getY() - Coordinates.tileToPixel(getY());
			
			if(!(diffX >= -10 && diffX < 16 && diffY >= 1 && diffY <= 28)) { // differences to see if the player has moved out of the bomb, tested values
				_allowedToPassThru = false;
			}
			
			return _allowedToPassThru;
		}
	// TODO: xử lý va chạm với Flame của Bomb khác
		if(e instanceof Flame ) {
			time_explode();
			return true;
		}
		return false;
	}
}
