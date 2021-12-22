package entities.character.enemy.ai;

import entities.character.Bomber;
import entities.character.enemy.Enemy;

import java.lang.Math;

public class AIHigh extends AI {

	Bomber _bomber;
    Enemy _e;
	
	/**
	 * constructer cho AI High.
	 * @param bomber nhân vật điều khiển.
	 * @param e kẻ địch. 
	 */
	public AIHigh(Bomber bomber, Enemy e) {
		_bomber = bomber;
        _e = e;
	}

    /**
     * thuật toán bám đường.
     */
   @Override
	public int calculateDirection() {

        if(_bomber == null)
			return random.nextInt(4);
		
		int vertical = random.nextInt(2);
		
		if(vertical == 1) {
			int v = calculateRowDirection();
			if(v != -1)
				return v;
			else
				return calculateColDirection();
			
		} else {
			int h = calculateColDirection();
			
			if(h != -1)
				return h;
			else
				return calculateRowDirection();
		}
	}

	/**
	 * tính toán chênh lệch theo cột, lấy tọa độ theo hàng.
	 * @return
	 */
    protected int calculateColDirection() {
        int a = _bomber.getXTile();
        int b = _e.getXTile();
        if((a > b) && (Math.pow(a,2) - Math.pow(b,2) >= 3))
            return 1;
        else if((a < b) && (Math.pow(a,2) - Math.pow(b,2) <= 3))
            return 3;
        int ran = random.nextInt(2);
        if (ran == 1) return ran;
        return ran++;
	}
	
	/**
	 * tính toán chênh lệch theo hàng, lấy tọa độ theo cột.
	 * @return
	 */
	protected int calculateRowDirection() {
        int a = _bomber.getYTile();
        int b = _e.getYTile();
		if((a > b) && (Math.pow(a,2) - Math.pow(b,2) >= 3))
			return 2;
		else if((a < b) && (Math.pow(a,2) - Math.pow(b,2) <= 3))
			return 0;
		int ran = random.nextInt(2);
        if (ran == 2) return ran;
        return 0;
	}

    
}
