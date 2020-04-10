package demo.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayoutBorder extends JPanel
{
	public static void main(String[] args)
	{
		final EmptyWindow window = new EmptyWindow();
		window.add(new LayoutBorder());
		window.setVisible(true);
	}

	public LayoutBorder()
	{
		this.setLayout(new BorderLayout());
		this.add(new JButton("oben"), BorderLayout.NORTH);
		this.add(new JButton("Mitte"), BorderLayout.CENTER);
		this.add(new JButton("rechts"), BorderLayout.EAST);
		// statt JButton können hier auch andere JPandels stehen
	}
}
