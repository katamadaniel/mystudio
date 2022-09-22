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
import studio.Clients;

/**
 *
 * @author Danny
 */
public class ClientDAo {
    private Connection conn;
    private ResultSet rs;
    
    public ClientDAo() throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl= props.getProperty("dburl");
        //Connect to database
        conn= DriverManager.getConnection(dburl,user,password);
        
        JOptionPane.showMessageDialog(null,"Connected successfully to:"+dburl);
    }
    public void addClient(Clients theClient) throws Exception{
        PreparedStatement myst = null;
        try{
            //prepare statement
            myst= conn.prepareStatement("insert into Clients" 
                    +"(ClientName,ClientNature,Payable,Amount,ProjectProgress,StaffAssigned,Equipment)"
                    +"values(?,?,?,?,?,?,?)");
            //set parameters
            myst.setString(1,theClient.getClientName());
            myst.setString(2,theClient.getClientNature());
            myst.setInt(3,theClient.getPayable());
            myst.setString(4,theClient.getProjectProgress());
            myst.setBigDecimal(5,theClient.getAmount());
            myst.setString(6,theClient.getProjectProgress());
            myst.setString(7,theClient.getStaffAssigned());
            myst.setString(8,theClient.getEquipment());
            //Execute Sql Query
            myst.executeUpdate();
        }
        finally{
         close(myst);   
        }
            
        }
    public void deleteClient(int ClientsID) throws Exception{
        PreparedStatement myst =null;
        
        try{
           //prepare statement
            myst=conn.prepareStatement("delete from Clients where id=?");
            //set parameters
            myst= setInt(1,ClientsID);
            //ececute query
            myst.executeUpdate();
        }
        finally{
            close(myst);
        }
    }

    public List<Clients> getAllClients() throws Exception{
        List<Clients> list = new ArrayList<>();
        
        Statement st= null;
            ResultSet rs= null;
            try{
                st=conn.createStatement();
                rs=st.executeQuery("Select * from Clients");
                while(rs.next()){
                    Clients tempClients = convertRowToClients(rs);
                    list.add(tempClients);
                            
                }
                return list;
            }
            finally {
                close(st);
            }
    }
    public List<Clients> SearchClients(String ClientName) throws Exception{
         List<Clients> list = new ArrayList<>();
         
         PreparedStatement st = null;
         ResultSet rs = null; 
         
         try{
             ClientName+="%";
             st= conn.prepareStatement("select * from Clients where Clients_Name like ?");
             
             st.setString(1,ClientName);
             rs=st.executeQuery();
             
             while(rs.next()){
                 Clients tempClients= convertRowToClients(rs);
                 list.add(tempClients);
             }
             return list;
             
         }
         finally {
             close(st);
         }
    }
    public List<ClientAuditHistory> getAuditHistory(int ClientsID) throws Exception{
        List<Clients> list = new ArrayList<>();
         PreparedStatement st = null;
         ResultSet rs =null;
                 
         return list;
    }
    private Clients convertRowToClients(ResultSet myRs) throws SQLException {
		
		int ClientsID = myRs.getInt("ID");
		String ClientName = myRs.getString("Client_Name");
		String ClientNature = myRs.getString("Client_Nature");
		int Payable = myRs.getInt("Payable");
		BigDecimal Amount = myRs.getBigDecimal("Amount");
                String ProjectProgress = myRs.getString("Project_Progress");
                String StaffAssigned = myRs.getString("Staff_Assigned");
                String Equipment = myRs.getString("Equpment");
		
		Clients tempClients = new Clients(ClientsID, ClientName, ClientNature, Payable, Amount, ProjectProgress, StaffAssigned, Equipment);
		
		return tempClients;
	}
    public void updateClient(Clients theClient,int userID) throws SQLException{
        PreparedStatement myst= null;
        try{
            //prepare statement
            myst=conn.prepareStatement("Update Client" +"set ClientName=?,ClientNature=?,Payable=?,Amount=?,ProjectProgress=?,StaffAssigned=?,Equipment?" +"where id=?");
        //set parameters
            
            myst.setString(1,theClient.getClientName());
            myst.setString(2,theClient.getClientNature());
            myst.setInt(3,theClient.getPayable());
            myst.setString(4,theClient.getProjectProgress());
            myst.setBigDecimal(5,theClient.getAmount());
            myst.setString(6,theClient.getProjectProgress());
            myst.setString(7,theClient.getStaffAssigned());
            myst.setString(8,theClient.getEquipment());
            myst.setInt(9, theClient.getId());
            
           //execute Query
            myst.executeQuery();
            //
            //audit history
            //
            //prepare statement
            myst= conn.prepareStatement("insert into audit_history" +"(user_ID,Client_ID,action,action_date_time)" +"values(?,?,?,?)");
            //set parameters
            myst.setInt(1, userID);
            myst.setInt(2, theClient.getId());
            myst.setString(3,"Updated Client.");
            myst.setTimestamp(4,new Timestamp(System.currentTimeMillis()));
            //execute SQL
            myst.executeUpdate();
    }
        finally{
            close(myst);
        }
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
		
		ClientDAo dao = new ClientDAo();
	}

}
