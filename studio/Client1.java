
package studio;

import java.math.BigDecimal;

public class Client1 {
    
    private int ClientsID;
    private String ClientName;
    private String ClientNature;
    private int Payable;
    private BigDecimal Amount;
    private String ProjectProgress;
    private String StaffAssigned;
    private String Equipment;

	public Client1(String ClientName,String ClientNature,int Payable,BigDecimal Amount,String ProjectProgress, String StaffAssigned, String Equipment) {

		this(0, ClientName, ClientNature, Payable, Amount, ProjectProgress, StaffAssigned, Equipment);
	}
	
	public Client1(int ClientsID,String ClientName,String ClientNature,int Payable,BigDecimal Amount,String ProjectProgress, String StaffAssigned, String Equipment) {
		super();
		this.ClientsID = ClientsID;
		this.ClientName = ClientName;
		this.ClientNature = ClientNature;
		this.Payable = Payable;
		this.Amount = Amount;
                this.ProjectProgress = ProjectProgress;
                this.StaffAssigned = StaffAssigned;
                this.Equipment = Equipment;
	}

    	public int getId() {
		return ClientsID;
	}

	public void setId(int id) {
		this.ClientsID = id;
	}

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String ClientName) {
		this.ClientName = ClientName;
	}

	public String getClientNature() {
		return ClientNature;
	}

	public void setClientNature(String ClientNature) {
		this.ClientNature = ClientNature;
	}

	public int getPayable() {
		return Payable;
	}

	public void setPayable(int Payable) {
		this.Payable = Payable;
	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public void setAmount(BigDecimal Amount) {
		this.Amount = Amount;
	}
        public String getProjectProgress() {
		return ProjectProgress;
	}

	public void setProjectProgress(String ProjectProgress) {
		this.ProjectProgress = ProjectProgress;
	}
        public String getStaffAssigned() {
		return StaffAssigned;
	}

	public void setStaffAssigned(String StaffAssigned) {
		this.StaffAssigned = StaffAssigned;
	}
        public String getEquipment() {
		return Equipment;
	}

	public void setEquipment(String Equipment) {
		this.Equipment = Equipment;
	}

	@Override
	public String toString() {
		return String
				.format("Clients [id=%s, ClientName=%s, ClinetNature=%s, Payable=%s, Amount=%s,ProjectProgress=%s,StaffAssigned=%s,Equipment=%s ]",
						ClientsID, ClientName, ClientNature, Payable, Amount, ProjectProgress, StaffAssigned, Equipment);
	}
}
