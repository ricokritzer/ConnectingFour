package demo.ui;

import javax.swing.JFrame;

public class EmptyWindow extends JFrame // wir legen hier fest, dass es sich bei der Klasse um ein Fenster handelt
{
	public static void main(String[] args)
	{
		new EmptyWindow();
	}

	public EmptyWindow()
	{
		this.setSize(1000, 1000); // 1000px hoch, 1000px breit
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // das ist das, was passiert, wenn jemand das "X" des
																// Fensters klickt
		this.setTitle("Titel");

		// hier kann noch mehr stehen

		this.setVisible(true); // der letzte Befehl, der das Fenster zeigt
	}
}
