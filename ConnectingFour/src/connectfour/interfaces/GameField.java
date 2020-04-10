package connectfour.interfaces;

import java.util.List;
import java.util.Optional;

public interface GameField
{
	List<Slot> getSlots();

	Optional<Player> getPlayerAtFieldWithCoordinates(int x, int y);
}
