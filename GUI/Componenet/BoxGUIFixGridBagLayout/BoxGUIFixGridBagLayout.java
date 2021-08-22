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
         * 生成窗体中的各种组件
         */
//        ImageIcon imageQQ =new ImageIcon(this.getClass().getResource("QQ面板.png"));
        JLabel component1=new JLabel();
        //组件1 是界面上的QQ蓝色面板图像，图像我们把它放在JLabel类对象上
//        ImageIcon imageqq =new ImageIcon(this.getClass().getResource("QQ头像.png"));
        JLabel component2=new JLabel();
        //组件2 是界面上的QQ企鹅图像，同理图像我们把它放在JLabel类对象上
        JTextField component3=new JTextField();
        component3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //组件3是用户的账号输入框
        JLabel component4=new JLabel("用户账号");
        component4.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        //组件4是用户的账号输入框右边的提示标签
        JTextField component5=new JTextField();
        component5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //组件5是用户的密码输入框
        JLabel component6=new JLabel("用户密码");
        component6.setBorder(BorderFactory.createLineBorder(Color.RED));
        //组件6是用户的密码输入框右边的提示标签
        JCheckBox component7=new JCheckBox("记住密码");
        //组件7是用户的“记住密码”的勾选键
        JCheckBox component8=new JCheckBox("自动登录");
        //组件8是用户的“自动登录”的勾选键
        JButton component9=new JButton("安全登录");
        component9.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        //组件8是用户的“安全登录”的按键
        /*
         * 对窗体进行布局
         */
        GridBagLayout gridBagLayout=new GridBagLayout(); //实例化布局对象
        mainPanel.setLayout(gridBagLayout);//mainPanel窗体对象设置为GridBagLayout布局                
        GridBagConstraints gridBagConstraints=new GridBagConstraints();//实例化这个对象用来对组件进行管理
        gridBagConstraints.fill=GridBagConstraints.BOTH;//该方法是为了设置如果组件所在的区域比组件本身要大时的显示情况 
        //NONE：不调整组件大小。 
        //HORIZONTAL：加宽组件，使它在水平方向上填满其显示区域，但是不改变高度。 
        //VERTICAL：加高组件，使它在垂直方向上填满其显示区域，但是不改变宽度。 
        //BOTH：使组件完全填满其显示区域。 
        /*
         * 分别对组件进行设置
         */
        //组件1(gridx,gridy)组件的左上角坐标，gridwidth，gridheight：组件占用的网格行数和列数
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.gridwidth=4;                                             
        gridBagConstraints.gridheight=4;            
        gridBagLayout.setConstraints(component1, gridBagConstraints);
        //组件2
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
         * 窗体的基本设置
         */
        JFrame jf=new JFrame();
//        jf.setSize(450,300);
        jf.setSize(700,500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(null);     
//        jf.setResizable(false);
        /*
         * 把所有组件加入jf窗体对象中去
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
