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
//            // 获取当前单元格的编辑器组件
//            Component comp = getComponent();
//
//            // 获取当前单元格编辑器输入的值
//            Object obj = getCellEditorValue();
//            
//            // 如果当前单元格编辑器输入的值不是数字，则返回 false（表示数据非法，不允许设置，无法保存）
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
//            	// 数据非法时，设置编辑器组件内的内容颜色为红色
//                comp.setForeground(Color.RED);
//                return false;
//            }
//
//            comp.setForeground(Color.BLACK);
//            // 合法数据交给父类处理
//            return super.stopCellEditing();
//        }
        
        @Override
        public boolean stopCellEditing() {
            // 获取当前单元格的编辑器组件
            Component comp = getComponent();

            // 获取当前单元格编辑器输入的值
            Object obj = getCellEditorValue();

            // 如果当前单元格编辑器输入的值不是数字，则返回 false（表示数据非法，不允许设置，无法保存）
            if (obj == null || !obj.toString().matches("[0-9]*")) {
                // 数据非法时，设置编辑器组件内的内容颜色为红色
                comp.setForeground(Color.RED);
//                return false;
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
}
