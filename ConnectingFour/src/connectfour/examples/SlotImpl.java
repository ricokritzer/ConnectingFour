package connectfour.examples;

import java.util.ArrayList;
import java.util.List;

import connectfour.interfaces.Coin;
import connectfour.interfaces.Player;
import connectfour.interfaces.Slot;

public class SlotImpl implements Slot
{
	private final List<Coin> coins = new ArrayList<>(); // anfangs leer, da keine Coins enthalten

	private final int rowCount;

	public SlotImpl(int rowCount)
	{
		this.rowCount = rowCount;
	}

	@Override
	public List<Coin> getCoins()
	{
		return coins;
	}

	@Override
	public void throwCoinOf(Player player)
	{
		coins.add(new CoinImpl(player));
	}

	@Override
	public int getRowCount()
	{
		return rowCount;
	}
}
