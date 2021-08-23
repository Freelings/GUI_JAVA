package TableFelix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class NewEditorDropsTable extends JFrame {
	
    Object[] columnNames = {"Column1", "Column2", "Column3", "Column4", "Column5"};

    Object[][] rowData = {
            {"Row1", null, null, null, null},
            {"Row2", null, null, null, null},
            {"Row3", null, null, null, null},
            {"Row4", null, null, null, null},
            {"Row5", null, null, null, null},
            {"Row6", null, null, null, null},
            {"Row7", null, null, null, null},
            {"Row8", null, null, null, null},
    };
    
	public static void main(String[] args) {
		NewEditorDropsTable table = new NewEditorDropsTable();
		System.out.println("*************************");
	}

	private static final long serialVersionUID = -6482185144620414655L;
	
	JFrame jf = new JFrame();
	
	public NewEditorDropsTable() {
    	
		jf.setTitle("Test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setSize(800, 500);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBounds(0, 0, 500, 100);
                
        JTable table = new JTable(rowData, columnNames);
        MyCellEditor checkEditor = new MyCellEditor(new JCheckBox());
        MyCellEditor textEditor = new MyCellEditor(new JTextField());
        MyCellEditor dropsEditor = new MyCellEditor(new DropBox());
        
        TableColumn tableColumn = table.getColumn(columnNames[1]);
        tableColumn.setCellEditor(checkEditor);
        tableColumn = table.getColumn(columnNames[2]);
        tableColumn.setCellEditor(textEditor);
        tableColumn = table.getColumn(columnNames[3]);
        tableColumn.setCellEditor(dropsEditor);


        JScrollPane scrollPane = new JScrollPane(table);
        
        // �Ȼ�ȡ ���ģ�� ����
        TableModel tableModel = table.getModel();

        // �� ���ģ���� ��� ���ݸı������
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // ��һ�� �� ���һ�� ���ı���У�ֻ�ı���һ�У���������ͬ��
                int firstRow = e.getFirstRow();
                int lastRow = e.getLastRow();

                // ���ı����
                int column = e.getColumn();

                // �¼������ͣ����ܵ�ֵ��:
                //     TableModelEvent.INSERT   ���л����е����
                //     TableModelEvent.UPDATE   �������ݵĸ���
                //     TableModelEvent.DELETE   ���л��б��Ƴ�
                int type = e.getType();
                System.out.println(firstRow + " " + lastRow + " " + column + " " + type) ;
                System.out.println(table.getValueAt(firstRow, column).getClass());
                System.out.println(table.getValueAt(firstRow, column).toString());
            }
        });

        
        panel.add(scrollPane);

        jf.add(panel);
        jf.setVisible(true);
    }
	
	public static class MyCellEditor extends DefaultCellEditor {

		private static final long serialVersionUID = -352753582352511143L;

		public MyCellEditor(JTextField textField) {
            super(textField);
        }

        public MyCellEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public MyCellEditor(JComboBox<String> comboBox) {
            super(comboBox);
        }

        @Override
        public boolean stopCellEditing() {
            // ��ȡ��ǰ��Ԫ��ı༭�����
            Component comp = getComponent();

            // ��ȡ��ǰ��Ԫ��༭�������ֵ
            Object obj = getCellEditorValue();
            
            // �����ǰ��Ԫ��༭�������ֵ�������֣��򷵻� false����ʾ���ݷǷ������������ã��޷����棩
            if (obj == null || !obj.toString().matches("[0-9]*")) {
                // ���ݷǷ�ʱ�����ñ༭������ڵ�������ɫΪ��ɫ
//                comp.setForeground(Color.RED);
            }
            else
            {
                // ���ݺϷ�ʱ�����ñ༭������ڵ�������ɫΪ��ɫ
                comp.setForeground(Color.BLACK);
            }
            // �Ϸ����ݽ������ദ��
            return super.stopCellEditing();
        }
    }
	
	public static class DropBox extends JComboBox<String>
	{
		private static final long serialVersionUID = -9038572563497027267L;
		
		static String[] operators = new String[]{"a", "b", "c"};
		
		public DropBox()
		{
			super(operators);
		}
	}
}
