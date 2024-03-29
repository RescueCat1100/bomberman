package entities.character.enemy;


import entities.character.enemy.ai.AIMedium;
import graphics.Sprite;
import main.Board;

public class Oneal extends Enemy {

    /**
     * đuổi
     * @param x
     * @param y
     * @param board
     */
	public Oneal (int x, int y, Board board) {
        super(x, y, board, Sprite.oneal_dead, 0.8, 100);
        _sprite = Sprite.oneal_left1;
        _ai = new AIMedium(_board.getBomber(), this);
        _direction = _ai.calculateDirection();
        
    }

    @Override
    protected void chooseSprite() {
        switch (_direction) {
            case 0:
            case 1:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60);
                } else {
                    _sprite = Sprite.oneal_right1;
                }
                break;
            case 2:
            case 3:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60);
                } else {
                    _sprite = Sprite.oneal_left1;
                }
                break;
        }
    }
}
