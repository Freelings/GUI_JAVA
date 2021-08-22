package BoxGUIFixXYLocation;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BoxGUIFixXYLocation extends JFrame {

	private static final long serialVersionUID = 6208577374223106177L;
	JPanel mainPanel = new JPanel();
	
	public BoxGUIFixXYLocation(int width, int height)
	{	
		this.setSize(width, height);
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
        JPanel panel01 = new SelfDefineJPanel(300, 200);
        panel01.setBorder(BorderFactory.createLineBorder(Color.RED));       // �߱߿�

        JPanel panel02 = new SelfDefineJPanel(300, 200);
        panel02.setBorder(BorderFactory.createLineBorder(Color.BLUE));   // ����߿�
        
        JPanel panel03 = new SelfDefineJPanel(300, 200);
        panel03.setBorder(BorderFactory.createLineBorder(Color.BLACK));   // ����߿�
        
		mainPanel.setLayout(null);

		panel01.setBounds(0, 0, 300, 200);
		mainPanel.add(panel01);
		
		panel02.setBounds(300, 200, 300, 200);
		mainPanel.add(panel02);
		
		panel03.setBounds(600, 400, 300, 200);
		mainPanel.add(panel03);
		
		this.add(mainPanel);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		mainPanel.setBounds(0, 0, 900, 600);
		
//		this.setResizable(false);;
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	private static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));

        panel.add(new JLabel("һ����ǩ"));
        panel.add(new JButton("һ����ť"));
        panel.add(new JRadioButton("��ѡ��ť"));
        panel.add(new JCheckBox("��ѡ��"));

        return panel;
    }
}
