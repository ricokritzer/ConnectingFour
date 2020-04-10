package connectfour.ui;

import java.awt.Color;

import connectfour.examples.GameImpl;
import connectfour.examples.GameUI;
import connectfour.examples.PlayerLocal;
import connectfour.interfaces.Game;
import connectfour.interfaces.Player;

public class Main
{
	public static void main(String[] args)
	{
		final Player player1 = new PlayerLocal("Spieler 1", Color.RED);
		final Player player2 = new PlayerLocal("Spieler 2", Color.YELLOW);

		final Game game = new GameImpl(6, 7, player1, player2);
		final GameUI ui = new GameUI(game);
	}
}
