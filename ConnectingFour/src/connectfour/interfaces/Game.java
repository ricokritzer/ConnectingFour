package connectfour.interfaces;

public interface Game
{
	void join(Player player);

	GameField getGameField();

	void throwCoinInto(Slot slot);

	int getRowCount();

	int getSlotCount();
}
