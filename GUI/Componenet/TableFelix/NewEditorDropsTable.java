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

public class SimpleTable extends JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -6482185144620414655L;
	
	JFrame jf = new JFrame();
	
	public SimpleTable() {
    	
		jf.setName("Test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(900, 600);
        JPanel panel = new JPanel(new BorderLayout());
                
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
        
        JTable table = new JTable(rowData, columnNames);
        MyCellEditor checkEditor = new MyCellEditor(new JCheckBox());
        MyCellEditor textEditor = new MyCellEditor(new JCheckBox());
        
        TableColumn tableColumn = table.getColumn(columnNames[0]);
//        tableColumn.setCellEditor(cellEditor);
        tableColumn = table.getColumn(columnNames[1]);
        tableColumn.setCellEditor(checkEditor);
        tableColumn = table.getColumn(columnNames[2]);
        tableColumn.setCellEditor(textEditor);
        tableColumn = table.getColumn(columnNames[3]);
        tableColumn.setCellEditor(checkEditor);
        tableColumn = table.getColumn(columnNames[4]);
        tableColumn.setCellEditor(textEditor);
        
        table.setPreferredScrollableViewportSize(new Dimension(900, 100));
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
            }
        });

        
        panel.add(scrollPane, BorderLayout.NORTH);

        jf.setContentPane(scrollPane);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
	
	public static class MyCellEditor extends DefaultCellEditor {

        public MyCellEditor(JTextField textField) {
            super(textField);
        }

        public MyCellEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public MyCellEditor(JComboBox comboBox) {
            super(comboBox);
        }

//        @Override
//        public boolean stopCellEditing() {
//            // ��ȡ��ǰ��Ԫ��ı༭�����
//            Component comp = getComponent();
//
//            // ��ȡ��ǰ��Ԫ��༭�������ֵ
//            Object obj = getCellEditorValue();
//            
//            // �����ǰ��Ԫ��༭�������ֵ�������֣��򷵻� false����ʾ���ݷǷ������������ã��޷����棩
//            if (obj.toString().matches("[0-9]*")) 
//            {
//            	System.out.println( "Numbers: " + obj.toString());
//            }
//            else if(obj instanceof Boolean)
//            {
//            	System.out.println( "Boolean: " + obj.toString());
//            }
//            else
//            {
//            	// ���ݷǷ�ʱ�����ñ༭������ڵ�������ɫΪ��ɫ
//                comp.setForeground(Color.RED);
//                return false;
//            }
//
//            comp.setForeground(Color.BLACK);
//            // �Ϸ����ݽ������ദ��
//            return super.stopCellEditing();
//        }
        
        @Override
        public boolean stopCellEditing() {
            // ��ȡ��ǰ��Ԫ��ı༭�����
            Component comp = getComponent();

            // ��ȡ��ǰ��Ԫ��༭�������ֵ
            Object obj = getCellEditorValue();

            // �����ǰ��Ԫ��༭�������ֵ�������֣��򷵻� false����ʾ���ݷǷ������������ã��޷����棩
            if (obj == null || !obj.toString().matches("[0-9]*")) {
                // ���ݷǷ�ʱ�����ñ༭������ڵ�������ɫΪ��ɫ
                comp.setForeground(Color.RED);
//                return false;
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
}
