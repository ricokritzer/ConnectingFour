package connectfour.examples;

import java.util.ArrayList;
import java.util.List;

import connectfour.interfaces.GameField;
import connectfour.interfaces.Slot;

public class GameFieldImpl implements GameField
{
	private List<Slot> slots = new ArrayList<>();

	public GameFieldImpl(int slotCount)
	{
		for (int i = 0; i < slotCount; i++)
		{
			slots.add(new SlotImpl(slotCount));
		}
	}

	@Override
	public List<Slot> getSlots()
	{
		return slots;
	}
}