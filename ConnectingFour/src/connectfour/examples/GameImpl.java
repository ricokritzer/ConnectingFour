package connectfour.examples;

import connectfour.interfaces.Game;
import connectfour.interfaces.GameField;
import connectfour.interfaces.Player;
import connectfour.interfaces.Slot;

public class GameImpl implements Game
{
	private final int rowCount;
	private final int slotCount;
	private final GameField gameField;

	private final Player player1;
	private final Player player2;

	private Player currentPlayer;

	public GameImpl(int rows, int slots, Player player1, Player player2)
	{
		this.rowCount = rows;
		this.slotCount = slots;
		this.player1 = player1;
		this.player2 = player2;

		this.currentPlayer = player1;

		gameField = new GameFieldImpl(slots);
	}

	@Override
	public GameField getGameField()
	{
		return gameField;
	}

	@Override
	public void throwCoinInto(Slot slot)
	{
		if (slot.getCoins().size() < rowCount)
		{
			// noch Patz im Schacht
			slot.throwCoinOf(currentPlayer);

			nextPlayer();
		}
	}

	private void nextPlayer()
	{
		if (currentPlayer == player1)
		{
			currentPlayer = player2;
		}
		else
		{
			currentPlayer = player1;
		}
	}

	@Override
	public int getRowCount()
	{
		return rowCount;
	}

	@Override
	public int getSlotCount()
	{
		return slotCount;
	}

	@Override
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
}
