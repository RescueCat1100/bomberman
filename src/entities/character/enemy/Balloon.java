package entities.character.enemy;

import entities.character.enemy.ai.AILow;
import graphics.Sprite;
import main.Board;

public class Balloon extends Enemy {
	
	/**
	 * Chạy random.
	 * @param x tọa độ x
	 * @param y tọa độ y
	 * @param board map
	 */
	public Balloon(int x, int y, Board board) {
		super(x, y, board, Sprite.balloom_dead, 0.5, 100);
		
		_sprite = Sprite.balloom_left1;
		
		_ai = new AILow();
		_direction = _ai.calculateDirection();
                
	}

	@Override
	protected void chooseSprite() {
		switch(_direction) {
			case 0:
			case 1:
					_sprite = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60);
				break;
			case 2:
			case 3:
					_sprite = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60);
				break;
		}
	}
}
