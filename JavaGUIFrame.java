import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class JavaGUIFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public JavaGUIFrame(String title)
	{
		setTitle(title);
		setSize(300, 300);
		setLocation(400, 400);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowOpened(WindowEvent e)
			{
				System.out.println("Beginning window session.");
			}
		});
		
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent f)
			{
				System.out.println("Window closed. Program will now exit.");
				System.exit(0);
			}
		});
		
		addWindowListener(new WindowAdapter()
		{
			public void windowIconified(WindowEvent g)
			{
				System.out.println("Window minimized to desktop. To return to window you must restore it.");
			}
		});
		
		addWindowListener(new WindowAdapter()
		{
			public void windowDeiconified(WindowEvent h)
			{
				System.out.println("Window restored.");
			}
		});
		
		Container component = getContentPane();
		component.add(new JavaPaintPanel());
		component.add(new JavaGUIButtons());
	}	
}
