package BoxGUIFixGridBagLayout;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxGUIFixGridBagLayout extends JFrame {

	private static final long serialVersionUID = 2203060532261130664L;
	
    public static void main(String args[]){
    	BoxGUIFixGridBagLayout ui=new BoxGUIFixGridBagLayout();
        ui.show();
    }
    public void show()
    {
    	JPanel mainPanel = new JPanel();

        /*
         * ���ɴ����еĸ������
         */
//        ImageIcon imageQQ =new ImageIcon(this.getClass().getResource("QQ���.png"));
        JLabel component1=new JLabel();
        //���1 �ǽ����ϵ�QQ��ɫ���ͼ��ͼ�����ǰ�������JLabel�������
//        ImageIcon imageqq =new ImageIcon(this.getClass().getResource("QQͷ��.png"));
        JLabel component2=new JLabel();
        //���2 �ǽ����ϵ�QQ���ͼ��ͬ��ͼ�����ǰ�������JLabel�������
        JTextField component3=new JTextField();
        component3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //���3���û����˺������
        JLabel component4=new JLabel("�û��˺�");
        component4.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        //���4���û����˺�������ұߵ���ʾ��ǩ
        JTextField component5=new JTextField();
        component5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //���5���û������������
        JLabel component6=new JLabel("�û�����");
        component6.setBorder(BorderFactory.createLineBorder(Color.RED));
        //���6���û�������������ұߵ���ʾ��ǩ
        JCheckBox component7=new JCheckBox("��ס����");
        //���7���û��ġ���ס���롱�Ĺ�ѡ��
        JCheckBox component8=new JCheckBox("�Զ���¼");
        //���8���û��ġ��Զ���¼���Ĺ�ѡ��
        JButton component9=new JButton("��ȫ��¼");
        component9.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        //���8���û��ġ���ȫ��¼���İ���
        /*
         * �Դ�����в���
         */
        GridBagLayout gridBagLayout=new GridBagLayout(); //ʵ�������ֶ���
        mainPanel.setLayout(gridBagLayout);//mainPanel�����������ΪGridBagLayout����                
        GridBagConstraints gridBagConstraints=new GridBagConstraints();//ʵ�����������������������й���
        gridBagConstraints.fill=GridBagConstraints.BOTH;//�÷�����Ϊ���������������ڵ�������������Ҫ��ʱ����ʾ��� 
        //NONE�������������С�� 
        //HORIZONTAL���ӿ������ʹ����ˮƽ��������������ʾ���򣬵��ǲ��ı�߶ȡ� 
        //VERTICAL���Ӹ������ʹ���ڴ�ֱ��������������ʾ���򣬵��ǲ��ı��ȡ� 
        //BOTH��ʹ�����ȫ��������ʾ���� 
        /*
         * �ֱ�������������
         */
        //���1(gridx,gridy)��������Ͻ����꣬gridwidth��gridheight�����ռ�õ���������������
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridwidth=4;                                             
        gridBagConstraints.gridheight=4;            
        gridBagLayout.setConstraints(component1, gridBagConstraints);
        //���2
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=4;
        gridBagConstraints.gridwidth=1;                                             
        gridBagConstraints.gridheight=4;            
        gridBagLayout.setConstraints(component2, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=4;
        gridBagConstraints.gridwidth=2;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component3, gridBagConstraints);

        gridBagConstraints.gridx=3;
        gridBagConstraints.gridy=4;
        gridBagConstraints.gridwidth=1;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component4, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=5;
        gridBagConstraints.gridwidth=2;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component5, gridBagConstraints);

        gridBagConstraints.gridx=3;
        gridBagConstraints.gridy=5;
        gridBagConstraints.gridwidth=2;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component6, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=6;
        gridBagConstraints.gridwidth=1;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component7, gridBagConstraints);

        gridBagConstraints.gridx=2;
        gridBagConstraints.gridy=6;
        gridBagConstraints.gridwidth=1;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component8, gridBagConstraints);

        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=7;
        gridBagConstraints.gridwidth=2;                                             
        gridBagConstraints.gridheight=1;            
        gridBagLayout.setConstraints(component9, gridBagConstraints);
        
        /*
         * ����Ļ�������
         */
        JFrame jf=new JFrame();
//        jf.setSize(450,300);
        jf.setSize(700,500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(null);     
//        jf.setResizable(false);
        /*
         * �������������jf���������ȥ
         */
        mainPanel.add(component1);
        mainPanel.add(component2);
        mainPanel.add(component3);
        mainPanel.add(component4);
        mainPanel.add(component5);
        mainPanel.add(component6);
        mainPanel.add(component7);
        mainPanel.add(component8);
        mainPanel.add(component9);

        mainPanel.setVisible(true);
        mainPanel.setBounds(0, 0, 600, 400);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jf.add(mainPanel);
        jf.setVisible(true);
    }
}
