package connectfour.interfaces;

public interface Game
{
	GameField getGameField();

	void throwCoinInto(Slot slot);

	int getRowCount();

	int getSlotCount();

	Player getCurrentPlayer();
}
