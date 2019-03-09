/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-20
 */

import java.util.*;

public class Board {
	private int boardSize;
	private int gameDifficulty;
	private GameObject[][] boardField;

	public Board(Game currentGame) {
		this.boardSize = currentGame.getSettings().getBoardSize();
		this.gameDifficulty = currentGame.getSettings().getGameDifficulty();
		this.initializeBoard(boardSize, gameDifficulty);
		System.out.println(this.display());
	}

	public Board(Game currentGame, Board boardToCopy) {
		this.boardSize = currentGame.getSettings().getBoardSize();
		this.gameDifficulty = currentGame.getSettings().getGameDifficulty();
		this.boardField = boardToCopy.getBoardField();
	}

	public GameObject getObjectAtCoords(int xPos, int yPos) {
		return new GameObject(this, boardField[xPos][yPos]);
	}

	public int getBoardSize() {
		return boardSize;
	}

	public GameObject[][] getBoardField(){
		GameObject[][] copyField = new GameObject[boardSize][boardSize];
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				copyField[row][col] = this.getObjectAtCoords(col, row);
			}
		}
		return copyField;
	}

	public void initializeBoard(int size, int difficulty) {
		Random rand = new Random();
		boardField = new GameObject[size][size];
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				if (rand.nextInt(100) <= difficulty)
					boardField[row][col] = new Mine(this, col, row);
				else {
					boardField[row][col] = new Detector(this, col, row);
				}
			}
		}
		for (int row = 0; row < boardSize; row++) {
			for (int col = 0; col < boardSize; col++) {
				boardField[row][col].setMarker();
			}
		}
	}

	public String display() {
		StringBuilder builder = new StringBuilder();
		builder.append("  X");
		for (int col = 0; col < boardSize; col++)
			if (col < 11) builder.append("  " + col);
			else builder.append(" " + col);
		builder.append("\n");
		for (int row = 0; row < boardSize; row++) {
			if (row < 10) builder.append("  " + row);
			else builder.append(" " + row);
			for (int col = 0; col < boardSize; col++) {
				builder.append("  ");
				if (boardField[row][col].isRevealed() == true)
					builder.append(boardField[row][col].getMarker());
				else
					builder.append('#');
			}
			builder.append("\n");
		}
		return builder.toString();
	}

	public int mineScan(int x1, int x2, int y1, int y2) {
		int mineScanCount = 0;
		for (int row = y1; row <= y2; row++) {
			for (int col = x1; col <= x2; col++) {
				if (boardField[row][col] instanceof Mine)
					mineScanCount += 1;
			}
		}
		return mineScanCount;
	}
}
