package connectfour.interfaces;

import java.util.List;

public interface GameField
{
	List<Slot> getSlots();

	boolean isCoinFrom(Player player, int x, int y);
}
