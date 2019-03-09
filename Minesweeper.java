/**
 * Subclass of GameObject
 * @author Rex J. Leniczek
 * @version 0.1
 * @since 2019-02-16
 */

public class Minesweeper {
	public Minesweeper() {
		System.out.println("Welcome to Minesweeper!");
		Menu gameMenu = new Menu();
	}

	public static void main(String[] args) {
		Minesweeper game = new Minesweeper();
	}
}
