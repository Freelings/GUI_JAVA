package Appplication;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testGUI extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6299262399856481281L;

	public static void main(String [] args)
	{
		JFrame jf = new JFrame("test");
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel contentPanel = new JPanel();
		jf.setContentPane(contentPanel);
	}
	
}
