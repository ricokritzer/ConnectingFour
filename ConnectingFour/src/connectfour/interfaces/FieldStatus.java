package connectfour.interfaces;

import java.awt.Color;

public enum FieldStatus
{
	FREE(Color.WHITE), PLAYER1(Color.RED), PLAYER2(Color.YELLOW);

	private final Color color;

	private FieldStatus(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}
}
