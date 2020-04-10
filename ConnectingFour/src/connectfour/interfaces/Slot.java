package connectfour.interfaces;

import java.util.List;

public interface Slot
{
	List<Coin> getCoins();

	void throwCoinOf(Player player);

	int getRowCount();
}
