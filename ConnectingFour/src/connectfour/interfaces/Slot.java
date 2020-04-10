package connectfour.interfaces;

import java.util.List;

public interface Slot
{
	List<FieldStatus> getFields();

	void throwCoinOf(Player player);

	int getRowCount();
}
