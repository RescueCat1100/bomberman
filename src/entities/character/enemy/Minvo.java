package entities.character.enemy;


import entities.character.enemy.ai.AIMedium;
import graphics.Sprite;
import main.Board;

public class Minvo extends Enemy{

    /**
     * chạy nhanh, đuổi, tạo tường tại vị trí đứng.
     * @param x
     * @param y
     * @param board
     */
    public Minvo (int x, int y, Board board) {
        super(x, y, board, Sprite.minvo_dead, 1, 100);
        _sprite = Sprite.minvo_left1;
        _ai = new AIMedium(_board.getBomber(), this);
        _direction = _ai.calculateDirection();
        
    }

    @Override
    protected void chooseSprite() {
        switch (_direction) {
            case 0:
            case 1:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, _animate, 60);
                } else {
                    _sprite = Sprite.minvo_right1;
                }
                break;
            case 2:
            case 3:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, _animate, 60);
                } else {
                    _sprite = Sprite.minvo_left1;
                }
                break;
        }
    }
}
