package connectfour.examples;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import connectfour.interfaces.Coin;
import connectfour.interfaces.Game;
import connectfour.interfaces.Player;
import connectfour.interfaces.Slot;

public class SlotUI extends JPanel
{
	private final Slot slot;
	private final Game game;
	private final static int spaceBetweenCells = 5;

	public SlotUI(Slot slot, Game game)
	{
		this.slot = slot;
		this.game = game;

		update();
	}

	private JButton createInsertButton(Game game)
	{
		final JButton butInsert = new JButton("v");
		butInsert.addActionListener(e -> onButtonClick());
		return butInsert;
	}

	private void onButtonClick()
	{
		game.throwCoinInto(slot);
		update();
	}

	private Component createFieldUI(Coin coin)
	{
		final JPanel pnlCoin = new JPanel();
		pnlCoin.setBackground(coin.getColor());
		return pnlCoin;
	}

	private Player noPlayer()
	{
		return new PlayerLocal("no Player", Color.WHITE);
	}

	public void update()
	{
		this.removeAll(); // entferne alles bisherige

		this.setLayout(new GridLayout(slot.getRowCount() + 1, 1, spaceBetweenCells, spaceBetweenCells)); // +1 für den
		// Button

		final List<Coin> coins = new ArrayList<>();
		coins.addAll(slot.getCoins());

		while (slot.getRowCount() > coins.size())
		{
			coins.add(new CoinImpl(noPlayer()));
		}

		Collections.reverse(coins); // wir beginnen oben zu zeichnen
		this.add(createInsertButton(game));
		coins.forEach(field -> this.add(createFieldUI(field)));

		this.revalidate();
		this.repaint();
	}
}
