/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studio;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import studio.Clients;

/**
 *
 * @author Danny
 */
public class ClientTableModel extends AbstractTableModel{
    	private static final int CLIENT_NAME_COL = 0;
	private static final int CLIENT_NATURE_COL = 1;
	private static final int PAYABLE_COL = 2;
        private static final int AMOUNT_COL = 3;
        private static final int PROJECT_PROGRESS_COL = 4;
	private static final int STAFF_ASSIGNED_COL = 5;
        private static final int EQUIPMENT_COL = 7;

	private String[] columnNames = { " ClientName", "ClientNature", "Payable", "Amount", "ProjectProgress", "StaffAsigned", "Equipment" };
	private List<Clients> clients;

	public ClientTableModel(List<Clients> theClients) {
		clients = theClients;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Clients tempClients= clients.get(row);

		switch (col) {
		case CLIENT_NAME_COL:
			return tempClients.getClientName();
		case CLIENT_NATURE_COL:
			return tempClients.getClientNature();
		case PAYABLE_COL:
			return tempClients.getPayable();
		case AMOUNT_COL:
			return tempClients.getAmount();
                case PROJECT_PROGRESS_COL:
                        return tempClients.getProjectProgress();
                case STAFF_ASSIGNED_COL:
                        return tempClients.getStaffAssigned();
                case EQUIPMENT_COL:
                        return tempClients.getEquipment();
		default:
			return tempClients.getClientName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	} 
}
