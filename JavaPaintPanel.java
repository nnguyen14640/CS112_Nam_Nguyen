import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JavaPaintPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		int x_position = 75;
		int y_position = 100;
		super.paintComponent(g);
		Font type = new Font("SansSerif", Font.BOLD, 16);
		Font nametype = new Font("SansSerif", Font.ITALIC, 16);
		FontMetrics metric = g.getFontMetrics(type);
		g.setFont(type);
		g.drawString("Hello ", x_position, y_position);
		g.setFont(nametype);
		x_position += metric.stringWidth("Hello ");
		g.drawString("Nam Nguyen", x_position, y_position);
	}
}
