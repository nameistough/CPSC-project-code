/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 */

public class Settings {
	private static final int sizeSmall = 8;
	private static final int sizeMedium = 16;
	private static final int sizeLarge = 24;
	private static final int difficultyEasy = 8;
	private static final int difficultyMedium = 16;
	private static final int difficultyHard = 24;
	private int boardSize = sizeMedium;
	private int gameDifficulty = difficultyMedium;
	private Game currentGame;

	public Settings(Game currentGame) {
		this.currentGame = currentGame;
		this.setBoardSize();
		this.setGameDifficulty();
	}

	public Settings(Game currentGame, Settings settingsToCopy) {
		this.boardSize = settingsToCopy.getBoardSize();
		this.gameDifficulty = settingsToCopy.getGameDifficulty();
	}

	public int getBoardSize() {
		return boardSize;
	}

	public int getGameDifficulty() {
		return gameDifficulty;
	}

	public void setGameDifficulty() {
		System.out.println("Choose a difficulty setting...\n[E]asy\n[M]edium\n[H]ard");
		String userInput = "";
		do {
			System.out.print("Selection: ");
			userInput = currentGame.getPlayer1().getPlayerController().getPlayerInput();
			switch (userInput.toUpperCase()) {
				case "E":
					this.gameDifficulty = difficultyEasy;
					break;
				case "M":
					this.gameDifficulty = difficultyMedium;
					break;
				case "H":
					this.gameDifficulty = difficultyHard;
					break;
				default:
					System.out.println("Invalid selection...");
					break;
			}
		} while (!(userInput.equalsIgnoreCase("E") || userInput.equalsIgnoreCase("M") || userInput.equalsIgnoreCase("H")));
	}

	public void setBoardSize() {
		System.out.println("Choose a board size setting:\n[S]mall\n[M]edium\n[L]arge");
		String userInput = "";
		do {
			System.out.print("Selection: ");
			userInput = currentGame.getPlayer1().getPlayerController().getPlayerInput();
			switch (userInput.toUpperCase()) {
				case "S":
					this.boardSize = sizeSmall;
					break;
				case "M":
					this.boardSize = sizeMedium;
					break;
				case "L":
					this.boardSize = sizeLarge;
					break;
				default:
					System.out.println("Invalid selection...");
					break;
			}
		} while (!(userInput.equalsIgnoreCase("S") || userInput.equalsIgnoreCase("M") || userInput.equalsIgnoreCase("L")));
	}
}
