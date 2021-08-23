package TableFelix;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FixedTable extends DefaultTableModel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7191350611887134383L;

	public FixedTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	@Override  
    public boolean isCellEditable(int row,int column){
		return column == 0? false : true;
    }
	
}
