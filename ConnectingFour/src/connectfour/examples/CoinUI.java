package connectfour.examples;

import java.awt.Color;

import javax.swing.JPanel;

import connectfour.interfaces.Coin;

public class CoinUI extends JPanel
{
	public CoinUI(Coin coin)
	{
		this.setBackground(coin.getColor());
	}

	private CoinUI()
	{
		this.setBackground(Color.WHITE);
	}

	public static CoinUI createPlaceholder()
	{
		return new CoinUI();
	}
}
