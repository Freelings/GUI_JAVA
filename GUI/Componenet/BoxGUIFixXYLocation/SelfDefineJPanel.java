package BoxGUIFixXYLocation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelfDefineJPanel extends JPanel {

	private static final long serialVersionUID = 9217998961087717276L;
	
	JPanel mainPanel = new JPanel();
	
	public SelfDefineJPanel(int width, int height)
	{	
		this.setSize(width, height);
		this.setLayout(null);
		
        JPanel panel01 = createPanel(width, height);
        panel01.setBorder(BorderFactory.createLineBorder(Color.RED));       // 线边框

        JPanel panel02 = createPanel(width, height);
        panel02.setBorder(BorderFactory.createLineBorder(Color.BLUE));   // 标题边框
        
        JPanel panel03 = createPanel(width, height);
        panel03.setBorder(BorderFactory.createLineBorder(Color.BLACK));   // 标题边框
        
		mainPanel.setLayout(null);

		panel01.setBounds(0, 0, width/3, height/3);
		mainPanel.add(panel01);
		
		panel02.setBounds(width/3, height/3, width/3, height/3);
		mainPanel.add(panel02);
		
		panel03.setBounds(width/3*2, height/3*2, width/3, height/3);
		mainPanel.add(panel03);
		
		this.add(mainPanel);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		mainPanel.setBounds(0, 0, width, height);
		
		this.setVisible(true);		
	}
	
	private static JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width/3, height/3));

        panel.add(new JLabel("一个标签"));
        panel.add(new JButton("一个按钮"));
        panel.add(new JRadioButton("单选按钮"));
        panel.add(new JCheckBox("复选框"));

        return panel;
    }
}