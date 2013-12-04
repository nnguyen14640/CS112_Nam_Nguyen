import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JavaGUIButtons extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JButton redButton;
	private JButton greenButton;
	private JButton blueButton;
	private JButton defaultButton;
	private ArrayList<JButton> buttons;
	private Color defaultcolor;

	public JavaGUIButtons()
	{
		buttons = new ArrayList<JButton>();
		defaultcolor = getBackground();
		
		redButton = new JButton("Red");
		greenButton = new JButton("Green");
		blueButton = new JButton("Blue");
		defaultButton = new JButton("Default");
		
		buttons.add(redButton);
		buttons.add(greenButton);
		buttons.add(blueButton);
		buttons.add(defaultButton);
		
		add(redButton);
		add(greenButton);
		add(blueButton);
		add(defaultButton);
		
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		blueButton.addActionListener(this);
		defaultButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Color background = getBackground();
		@SuppressWarnings("unused")
		Object source = e.getSource();
		String action = e.getActionCommand();
		
		if (action.equals("Red"))
		{
			background = new Color(143, 0, 36);
		}
		else if (action.equals("Green"))
		{
			background = new Color(68, 136, 103);
		}
		else if (action.equals("Blue"))
		{
			background = new Color(102, 179, 255);
		}
		else if (action.equals("Default"))
		{
			background = new Color(defaultcolor.getRed(), defaultcolor.getGreen(), defaultcolor.getBlue());
		}
		
		setBackground(background);
		repaint();
	}
}
