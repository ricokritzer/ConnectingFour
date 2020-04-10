package demo.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayoutGrid extends JPanel // das ist eine Komponenete, auf die man Dinge platzieren kann
{
	public static void main(String[] args)
	{
		final EmptyWindow window = new EmptyWindow();
		window.add(new LayoutGrid()); // wir nutzen das leere Fenster und fügen diesem das Tabellen-Layout zu
		window.setVisible(true); // wichtig, diese Zeile muss am Ende stehen, damit das Fenster neu gezeichnet
									// wird
	}

	public LayoutGrid()
	{
		final int rows = 5;
		final int cols = 5;
		this.setLayout(new GridLayout(rows, cols)); // z. B. ein TabellenLayout.

		this.add(new JButton("links oben"));
		this.add(new JButton("rechts daneben"));

		for (int i = 0; i < 23; i++) // Schleife für die Erstellung weiterer Buttons
		{
			this.add(new JButton("weiterer Button"));
		}
	}
}
