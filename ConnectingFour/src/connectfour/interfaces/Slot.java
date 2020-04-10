package connectfour.interfaces;

import java.util.List;

public interface Slot
{
	List<Coin> getCoins();

	void throwCoinOf(Player player);

	int getRowCount();

	void updateOnChange(UI ui); // UIs können sich mitteilen, dass sie Veränderungen mitgeteilt bekommen wollen
}
