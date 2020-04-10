package connectfour.examples;

import java.awt.Color;

import connectfour.interfaces.Game;
import connectfour.interfaces.Player;

public class PlayerLocal implements Player
{
	private final String name;
	private int points;
	private Color color;

	public PlayerLocal(String name, Color color)
	{
		this.name = name;
		this.color = color;
	}

	@Override
	public void yourTurnAt(Game game)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void addOnePoint()
	{
		points++;
	}

	@Override
	public int getPoints()
	{
		return points;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setPlayerColor(Color color)
	{
		this.color = color;
	}

	@Override
	public Color getPlayerColor()
	{
		return color;
	}
}
