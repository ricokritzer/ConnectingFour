package connectfour.interfaces;

public interface Game
{
	void join(Player player);

	GameField getGameField();

	void throwCoinOf(Player player, Slot intoSlot);
}
