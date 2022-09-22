
package studio;

import java.util.Date;
public class ClientAuditHistory {
    	private int userId;
	private int ClientsId;
	private String action;
	private Date actionDateTime;
	
	private String userFirstName;
	private String userLastName;
	
	
	public ClientAuditHistory(int userId, int ClientsId, String action,
			Date actionDateTime, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.ClientsId = ClientsId;
		this.action = action;
		this.actionDateTime = actionDateTime;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClientsId() {
		return ClientsId;
	}
	public void setClientsId(int ClientsId) {
		this.ClientsId = ClientsId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Date getActionDateTime() {
		return actionDateTime;
	}
	public void setActionDateTime(Date actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

	@Override
	public String toString() {
		return String
				.format("AuditHistory [userId=%s, ClientsId=%s, action=%s, actionDateTime=%s, userFirstName=%s, userLastName=%s]",
						userId, ClientsId, action, actionDateTime,
						userFirstName, userLastName);
	}
    
}
