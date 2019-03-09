/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.2
 * @since 2019-02-16
 */

public class GameObject {
	protected Board ownerBoard;
	protected int[] coords = new int[3];
	protected char marker = 0;
	protected boolean revealedBoolean = false;

	public GameObject(Board board, int xPos, int yPos, int zPos) {
		this.coords[0] = xPos;
		this.coords[1] = yPos;
		this.coords[2] = zPos;
		this.ownerBoard = board;
	}

	public GameObject(Board board, GameObject objectToCopy) {
		this.coords = objectToCopy.getCoords();
		this.marker = objectToCopy.getMarker();
		this.ownerBoard = board;
	}

    public void setRevealedBoolean(Boolean isRevealed) {
        revealedBoolean = isRevealed;
    }

	public boolean isRevealed() {
		return revealedBoolean;
	}

	public int[] getCoords() {
		int[] copyCoords = new int[3];
		copyCoords[0] = coords [0];
		copyCoords[1] = coords [1];
		copyCoords[2] = coords [2];
		return copyCoords;
	}

	public char getMarker() {
		return marker;
	}

	public void setMarker() {
	}
}
