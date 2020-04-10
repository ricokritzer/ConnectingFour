package connectfour.examples;

import java.awt.GridLayout;

import javax.swing.JFrame;

import connectfour.interfaces.Game;

public class GameUI extends JFrame
{
	private final Game game;

	private final static int spaceBetweenCells = 5;

	public GameUI(Game game)
	{
		this.game = game; // wir merken uns das Spiel, damit wir später damit arbeiten können

		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Beispiel: 4-gewinnt");

		this.setLayout(new GridLayout(1, game.getSlotCount(), spaceBetweenCells, spaceBetweenCells));
		game.getGameField().getSlots().forEach(slot -> this.add(new SlotUI(slot, game)));

		this.setVisible(true); // der letzte Befehl, der das Fenster zeigt
	}
}
