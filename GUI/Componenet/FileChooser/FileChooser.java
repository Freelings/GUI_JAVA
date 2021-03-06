package FileChooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileChooser extends JFrame implements ActionListener{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3812858559328873549L;
	
	JButton open = null;
	String folderChoosed = null;
	String fileChoosed = null;
	

    public FileChooser(){  
        open=new JButton("open");  
        this.add(open);  
        this.setBounds(400, 200, 100, 100);  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        open.addActionListener(this);  
    }  

    @Override  
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();  
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
        jfc.showDialog(new JLabel(), "Choose");  
        File file=jfc.getSelectedFile();  
        if(file.isDirectory()){  
        	fileChoosed = file.getAbsolutePath();
            System.out.println("Folder: " + file.getAbsolutePath());  
        }else if(file.isFile()){
        	fileChoosed = file.getAbsolutePath();
            System.out.println("File: " + file.getAbsolutePath());  
        }
        fileChoosed = jfc.getSelectedFile().getName();
        System.out.println(jfc.getSelectedFile().getName());  
          
    }

	public String getFolderChoosed() {
		return folderChoosed;
	}

	public String getFileChoosed() {
		return fileChoosed;
	}  
}