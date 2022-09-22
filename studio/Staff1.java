
package studio;
import java.math.BigDecimal;

public class Staff1 {
    private int StaffID;
    private String StaffName;
    private String Designation;
    private String Password;
    private BigDecimal Pay;
    
    public Staff1(String StaffName, String Designation, String Password,BigDecimal Pay) {

			this(0, StaffName, Designation, Password, Pay);
		}
		
		public Staff1(int id, String StaffName, String Designation, String Password,
				BigDecimal Pay) {
			super();
			this.StaffID = id;
			this.StaffName = StaffName;
			this.Designation = Designation;
			this.Password = Password;
			this.Pay = Pay;
		}

		public int getId() {
			return StaffID;
		}

		public void setId(int id) {
			this.StaffID = id;
		}

		public String getStaffName() {
			return StaffName;
		}

		public void setStaffName(String StaffName) {
			this.StaffName = StaffName;
		}

		public String getDesignation() {
			return Designation;
		}

		public void setDesignation(String Designation) {
			this.Designation = Designation;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String Password) {
			this.Password = Password;
		}

		public BigDecimal getPay() {
			return Pay;
		}

		public void setPay(BigDecimal Pay) {
			this.Pay = Pay;
		}

		@Override
		public String toString() {
			return String
					.format("Employee [id=%s, StaffName=%s, Designation=%s, Password=%s, pay=%s]",
							StaffID, StaffName, Designation, Password, Pay);
		}
}
