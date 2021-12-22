/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.character.enemy;

import main.*;
import entities.character.enemy.ai.AIHigh;
import graphics.Sprite;


public class Doll extends Enemy{
    /**
     * đuổi thông minh
     * @param x tọa độ x
     * @param y tọa độ y
     * @param board map
     */
    public Doll(int x, int y, Board board) {
        super(x, y, board, Sprite.doll_dead, 0.8, 100);

        _sprite = Sprite.doll_left1;

        _ai = new AIHigh(_board.getBomber(), this);
        _direction = _ai.calculateDirection();

    }

    @Override
    protected void chooseSprite() {
        switch (_direction) {
            case 0:
            case 1:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, _animate, 60);
                } else {
                    _sprite = Sprite.doll_right1;
                }
                break;
            case 2:
            case 3:
                if (_moving) {
                    _sprite = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, _animate, 60);
                } else {
                    _sprite = Sprite.doll_left1;
                }
                break;
        }
    }
}
