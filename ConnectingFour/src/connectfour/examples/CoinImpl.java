package connectfour.examples;

import java.awt.Color;

import connectfour.interfaces.Coin;
import connectfour.interfaces.Player;

public class CoinImpl implements Coin
{
	private final Player player;

	public CoinImpl(Player player)
	{
		this.player = player;
	}

	public Color getColor()
	{
		return player.getPlayerColor();
	}

	public Player getOwner()
	{
		return player;
	}
}
