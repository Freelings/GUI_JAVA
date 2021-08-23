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
        
        // 先获取 表格模型 对象
        TableModel tableModel = table.getModel();

        // 在 表格模型上 添加 数据改变监听器
        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // 第一个 和 最后一个 被改变的行（只改变了一行，则两者相同）
                int firstRow = e.getFirstRow();
                int lastRow = e.getLastRow();

                // 被改变的列
                int column = e.getColumn();

                // 事件的类型，可能的值有:
                //     TableModelEvent.INSERT   新行或新列的添加
                //     TableModelEvent.UPDATE   现有数据的更改
                //     TableModelEvent.DELETE   有行或列被移除
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
            // 获取当前单元格的编辑器组件
            Component comp = getComponent();

            // 获取当前单元格编辑器输入的值
            Object obj = getCellEditorValue();
            
            // 如果当前单元格编辑器输入的值不是数字，则返回 false（表示数据非法，不允许设置，无法保存）
            if (obj == null || !obj.toString().matches("[0-9]*")) {
                // 数据非法时，设置编辑器组件内的内容颜色为红色
//                comp.setForeground(Color.RED);
            }
            else
            {
                // 数据合法时，设置编辑器组件内的内容颜色为黑色
                comp.setForeground(Color.BLACK);
            }
            // 合法数据交给父类处理
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
