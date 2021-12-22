package entities.character.enemy.ai;

public class AILow extends AI {

	/**
	 * hướng đi ngẫu nhiên.
	 * trả về số nguyên random.
	 */
	@Override
	public int calculateDirection() {
		return random.nextInt(4);
	}

}
