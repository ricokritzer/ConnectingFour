package connectfour.interfaces;

public interface Game
{
	GameField getGameField();

	void throwCoinOf(Player player, Slot intoSlot);
}
