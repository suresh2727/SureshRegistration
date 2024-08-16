package Modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class Registration {
    private Connection con;
    HttpSession se;

    public Registration(HttpSession session) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); // load the drivers
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcregister", "root", "tiger");
            // connection with data base
            se = session;
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Registration(String name, String phone, String email, String pw) {
        PreparedStatement ps;
        String status = "";
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from mvcdata where phone='" + phone + "' or email='" + email + "';");
            boolean b = rs.next();
            if (b) {
                status = "existed";
            } else {
                ps = con.prepareStatement("insert into mvcdata values(0,?,?,?,?,now())");
                ps.setString(1, name);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setString(4, pw);
                int a = ps.executeUpdate();
                if (a > 0) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

	public String login(String email, String pass) {
		String status1 = "" , id="";
		String name = "" , emails = "";
		PreparedStatement ps;
        try {
            Statement st = null;
            ResultSet rs = null;
            st = con.createStatement();
            rs = st.executeQuery("select * from mvcdata where email='" + email + "' and password='" + pass + "';");
            boolean b = rs.next();
            if(b==true) {
            	id = rs.getString(1);
            	name = rs.getString(2);
            	emails = rs.getString(4);
            	
            	se.setAttribute("uname", name);
            	se.setAttribute("email", emails);
            	se.setAttribute("id", id);
            	status1 = "success";
            }
            else {
            	status1 = "failure";
            }
           
		
	}catch(Exception e) {
		e.printStackTrace();
	}
        return status1;
}
}
