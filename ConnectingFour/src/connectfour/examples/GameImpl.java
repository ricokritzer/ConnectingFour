package connectfour.examples;

import javax.swing.JOptionPane;

import connectfour.interfaces.Coin;
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

			checkGameEnds();

			nextPlayer();
		}
	}

	private void checkGameEnds()
	{
		boolean[][] gameField = getGameFieldAs2DArray();

		if (checkHorizontalGameEnd(gameField) || checkVerticalGameEnd(gameField) || checkDiagonalGameEnd(gameField))
		{
			JOptionPane.showMessageDialog(null, currentPlayer.getName() + " hat gewonnen");
		}
	}

	private boolean[][] getGameFieldAs2DArray()
	{
		boolean[][] gameField = new boolean[getSlotCount()][getRowCount()]; // quasi eine Tabelle
		for (int x = 0; x < this.gameField.getSlots().size(); x++)
		{
			Slot slot = this.gameField.getSlots().get(x);

			for (int y = 0; y < slot.getCoins().size(); y++)
			{
				Coin coin = slot.getCoins().get(y);
				gameField[x][y] = coin.getOwner() == currentPlayer;
			}
		}
		return gameField;
	}

	private boolean checkHorizontalGameEnd(boolean[][] gameField)
	{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkDiagonalGameEnd(boolean[][] gameField)
	{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkVerticalGameEnd(boolean[][] gameField)
	{
		// TODO Auto-generated method stub
		return false;
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
