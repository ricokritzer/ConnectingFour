package connectfour.examples;

import java.util.ArrayList;
import java.util.List;

import connectfour.interfaces.Coin;
import connectfour.interfaces.GameField;
import connectfour.interfaces.Player;
import connectfour.interfaces.Slot;

public class GameFieldImpl implements GameField
{
	private List<Slot> slots = new ArrayList<>();
	private final int slotCount;
	private final int rowCount;

	public GameFieldImpl(int slotCount, int rowCount)
	{
		this.slotCount = slotCount;
		this.rowCount = rowCount;

		for (int i = 0; i < slotCount; i++)
		{
			slots.add(new SlotImpl(rowCount));
		}
	}

	@Override
	public List<Slot> getSlots()
	{
		return slots;
	}

	@Override
	public boolean isCoinFrom(Player player, int x, int y)
	{
		if (x < 0)
		{
			return false;
		}
		if (y < 0)
		{
			return false;
		}
		if (x >= slotCount)
		{
			return false;
		}

		List<Coin> coins = slots.get(x).getCoins();
		if (y >= coins.size())
		{
			return false;
		}

		return coins.get(y).getOwner() == player;
	}
}
