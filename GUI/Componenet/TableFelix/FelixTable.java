package TableFelix;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FelixTable extends DefaultTableModel {
	
	
	public FelixTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	@Override  
    public boolean isCellEditable(int row,int column){
		return column == 0? false : true;
    }

	public TableColumn getColumn(Object object) {
		super.getColumn(object);
	}
	
}
