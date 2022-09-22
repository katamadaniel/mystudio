/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studio;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import studio.Staff;
/**
 *
 * @author Danny
 */
public class StaffDAO {
        private Connection conn;
    
    public StaffDAO() throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl= props.getProperty("dburl");
        //Connect to database
        conn= DriverManager.getConnection(dburl,user,password);
        
        JOptionPane.showMessageDialog(null,"Connected successfully to:"+dburl);
    }
    public void addStaff(Staff theStaff) throws Exception{
        PreparedStatement myst = null;
        try{
            //prepare statement
            myst= conn.prepareStatement("insert into Staff" 
                    +"(StaffName,Designation,Password,Pay)"
                    +"values(?,?,?,?,?)");
            //set parameters
            myst.setString(1,theStaff.getStaffName());
            myst.setString(2,theStaff.getDesignation());
            myst.setString(3,theStaff.getPassword());
            myst.setBigDecimal(5,theStaff.getPay());
            
            //Execute Sql Query
            myst.executeUpdate();
        }
        finally{
         close(myst);   
        }
            
        }
        public void updateClient(Staff theStaff,int userID) throws SQLException{
        PreparedStatement myst= null;
        try{
            //prepare statement
            myst=conn.prepareStatement("Update Staff" +"set StaffName=?,Designation=?,Pay=?,Password=?" +"where id=?");
        //set parameters
            
            myst.setString(1,theStaff.getStaffName());
            myst.setString(2,theStaff.getDesignation());
            myst.setBigDecimal(5,theStaff.getPay());
            myst.setString(8,theStaff.getPassword());
            myst.setInt(9, theStaff.getId());
            
           //execute Query
            myst.executeQuery();
            //
            //audit history
            //
            //prepare statement
            myst= conn.prepareStatement("insert into audit_history" +"(user_ID,Staff_ID,action,action_date_time)" +"values(?,?,?,?)");
            //set parameters
            myst.setInt(1, userID);
            myst.setInt(2, theStaff.getId());
            myst.setString(3,"Updated Staff.");
            myst.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            //execute SQL
            myst.executeUpdate();
    }
        finally{
            close(myst);
        }
    }
        public void deleteStaff(int StaffID) throws Exception{
        PreparedStatement myst =null;
        
        try{
           //prepare statement
            myst=conn.prepareStatement("delete from Staff where id=?");
            //set parameters
            myst= setInt(1,StaffID);
            //ececute query
            myst.executeUpdate();
        }
        finally{
            close(myst);
        }
    }
    public List<Staff> getAllStaff() throws Exception{
        List<Staff> list = new ArrayList<>();
        
        Statement st= null;
            ResultSet rs= null;
            try{
                st=conn.createStatement();
                rs=st.executeQuery("Select * from staff");
                while(rs.next()){
                    Staff tempStaff = convertRowToStaff(rs);
                    list.add(tempStaff);
                            
                }
                return list;
            }
            finally {
                close(st);
            }
    }
    public List<Staff> SearchStaff(String StaffName) throws Exception{
         List<Staff> list = new ArrayList<>();
         
         PreparedStatement st = null;
         ResultSet rs = null; 
         
         try{
             StaffName+="%";
             st= conn.prepareStatement("Select * from staff where Staff_Name like ?");
             
             st.setString(1,StaffName);
             rs=st.executeQuery();
             
             while(rs.next()){
                 Staff tempStaff= convertRowToStaff(rs);
                 list.add(tempStaff);
             }
             return list;
             
         }
         finally {
             close(st);
         }
    }
        public List<StaffAuditHistory> getAuditHistory(int StaffID) throws Exception{
        List<Staff> list = new ArrayList<>();
         PreparedStatement st = null;
         ResultSet rs =null;
                 
         return list;
    }
    private Staff convertRowToStaff(ResultSet myRs) throws SQLException {
		
		int StaffID = myRs.getInt("ID");
		String StaffName = myRs.getString("Staff_Name");
		String Designation = myRs.getString("Designation");
                String Password = myRs.getString("Password");
		BigDecimal Pay = myRs.getBigDecimal("Pay");
                
                Staff tempStaff = new Staff(StaffID, StaffName, Designation, Password, Pay);
                    
		return tempStaff;
	}
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement st) throws SQLException {
		close(st);		
	}

	public static void main(String[] args) throws Exception {
		
		StaffDAO dao = new StaffDAO();

	}

}
