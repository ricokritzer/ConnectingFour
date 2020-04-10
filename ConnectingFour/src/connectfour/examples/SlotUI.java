package connectfour.examples;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import connectfour.interfaces.Game;
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

	public void update()
	{
		this.removeAll(); // entferne alles bisherige

		this.setLayout(new GridLayout(slot.getRowCount() + 1, 1, spaceBetweenCells, spaceBetweenCells)); // +1 für den
		// Button

		final List<CoinUI> coinUIs = new ArrayList<>();
		slot.getCoins().forEach(coin -> coinUIs.add(new CoinUI(coin)));

		while (slot.getRowCount() > coinUIs.size())
		{
			coinUIs.add(CoinUI.createPlaceholder());
		}

		Collections.reverse(coinUIs); // wir beginnen oben zu zeichnen
		this.add(createInsertButton(game));
		coinUIs.forEach(coinUI -> this.add(coinUI));

		this.revalidate();
		this.repaint();
	}
}
