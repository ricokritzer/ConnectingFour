package connectfour.examples;

import javax.swing.JOptionPane;

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

		gameField = new GameFieldImpl(slots, rows);
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

			int x = gameField.getSlots().indexOf(slot);
			int y = slot.getCoins().size() - 1;

			checkGameEnds(x, y);

			nextPlayer();
		}
	}

	private void checkGameEnds(int x, int y)
	{
		if (gameEndsInc(x, y) || gameEndsDesc(x, y) || gameEndsHorizontal(x, y) || gameEndsVertical(x, y))
		{
			JOptionPane.showMessageDialog(null, currentPlayer.getName() + " hat gewonnen");
		}
	}

	private boolean gameEndsInc(int x, int y)
	{
		return countCoinsInDirection(x, y, -1, -1) + 1 + countCoinsInDirection(x, y, 1, 1) >= 4;
	}

	private boolean gameEndsDesc(int x, int y)
	{
		return countCoinsInDirection(x, y, -1, 1) + 1 + countCoinsInDirection(x, y, 1, -1) >= 4;
	}

	private boolean gameEndsVertical(int x, int y)
	{
		return countCoinsInDirection(x, y, 0, -1) + 1 + countCoinsInDirection(x, y, 0, 1) >= 4;
	}

	private boolean gameEndsHorizontal(int x, int y)
	{
		return countCoinsInDirection(x, y, -1, 0) + 1 + countCoinsInDirection(x, y, 1, 0) >= 4;
	}

	private int countCoinsInDirection(int xCoordinate, int yCoordinate, int xDelta, int yDelta)
	{
		int x = xCoordinate + xDelta;
		int y = yCoordinate + yDelta;
		if (gameField.isCoinFrom(currentPlayer, x, y))
		{
			return countCoinsInDirection(x, y, xDelta, yDelta) + 1;
		}
		else
		{
			return 0;
		}
	}

	private void nextPlayer()
	{
		if (currentPlayer == player1)
		{
			setCurrentPlayer(player2);
		}
		else
		{
			setCurrentPlayer(player1);
		}
	}

	private void setCurrentPlayer(Player player)
	{
		currentPlayer = player;
		player.yourTurnAt(this);
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
