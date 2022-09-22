/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studio;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import studio.Staff;

/**
 *
 * @author Danny
 */
public class StaffTableModel extends AbstractTableModel {
 
	private static final int STAFF_NAME_COL = 0;
	private static final int DESIGNATION_COL = 1;
	private static final int PASSWORD_COL = 2;
	private static final int SALARY_COL = 3;

	private String[] columnNames = { " StaffName", "Designation", "Password", "Pay" };
	private List<Staff> staff;

	public StaffTableModel(List<Staff> theStaff) {
		staff = theStaff;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return staff.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Staff tempStaff = staff.get(row);

		switch (col) {
		case STAFF_NAME_COL:
			return tempStaff.getStaffName();
		case DESIGNATION_COL:
			return tempStaff.getDesignation();
		case PASSWORD_COL:
			return tempStaff.getPassword();
		case SALARY_COL:
			return tempStaff.getPay();
		default:
			return tempStaff.getStaffName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}   
}
