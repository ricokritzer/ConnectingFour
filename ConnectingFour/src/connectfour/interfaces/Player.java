package connectfour.interfaces;

import java.awt.Color;

public interface Player
{
	void yourTurnAt(Game game);

	void addOnePoint();

	void setPlayerColor(Color color);

	Color getPlayerColor();

	int getPoints();

	String getName();
}
