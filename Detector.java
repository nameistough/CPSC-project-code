/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.2
 * @since 2019-02-16
 */
 
public class Detector extends GameObject {
	public Detector(Board board, int xPos, int yPos) { 
		super(board, xPos, yPos, 0);
		this.marker = (char)(43);
	}
	
	@Override
	public void setMarker() {
		int colS, colE, rowS, rowE;
		colS = colE = rowS = rowE = 1;
		if (coords[0] == 0) colS = 0;
		else if (coords[0] == ownerBoard.getBoardSize() - 1) colE = 0;
		if (coords[1] == 0) rowS = 0;
		else if (coords[1] == ownerBoard.getBoardSize() - 1) rowE = 0;
		int scanMineCount = ownerBoard.mineScan(coords[0] - colS, coords[0] + colE, coords[1] - rowS, coords[1] + rowE);
		if (scanMineCount != 0) this.marker = (char)(scanMineCount + 48);
		else this.marker = (char)(32); 
	}
}