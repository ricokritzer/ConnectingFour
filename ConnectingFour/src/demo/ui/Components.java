package demo.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Components extends JPanel
{
	public static void main(String[] args)
	{
		final EmptyWindow window = new EmptyWindow();
		window.add(new Components());
		window.setVisible(true);
	}

	public Components()
	{
		this.setLayout(new GridLayout(10, 1));

		JButton butHello = new JButton("say Hello");
		butHello.addActionListener(e -> sayHello());
		this.add(butHello);

		this.add(new JButton("Button"));
		this.add(new JPanel());
		this.add(new JRadioButton("RadioButton"));
		this.add(new JLabel("Label"));
		this.add(new JTextArea("TextArea"));
		this.add(new JTextField("TextField"));
		this.add(new JCheckBox("CheckBox"));

		final String[] texts = new String[2];
		texts[0] = "Combo";
		texts[1] = "Box";
		this.add(new JComboBox<String>(texts));
		this.add(new JMenuItem("MenuItem"));
	}

	private void sayHello()
	{
		JOptionPane.showMessageDialog(this, "Hello world"); // wir verwenden this, d.h. zentral im Bezug auf DIESE
															// JPanel, in welchem wir uns gerade befinden
	}

}
