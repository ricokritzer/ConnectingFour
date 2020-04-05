package connectfour.interfaces;

import java.util.List;

public interface Slot
{
	List<Field> getFields();

	void throwCoinOf(Player player);
}
