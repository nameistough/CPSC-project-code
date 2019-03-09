/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.2
 * @since 2019-02-16
 */
 
public class Mine extends GameObject {
	private boolean isFlagged = false;
	private static int mineCount = 0;
	 
	public Mine(Board board, int xPos, int yPos) { 
		super(board, xPos, yPos, 0);
		this.mineCount += 1;
		this.marker = 42;
	}
}