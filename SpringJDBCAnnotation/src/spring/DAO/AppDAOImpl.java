package spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import spring.model.User;

public class AppDAOImpl implements AppDAO {
	private DataSource dataSource;

	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> listUsers() {
		String sql = "select * from users";
		List<User> listUsers = new ArrayList<User>();
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User temp = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("address"),
						rs.getString("gender"), null, rs.getString("country"));
				listUsers.add(temp);

			}
			rs.close();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listUsers;

	}

	@Override
	public void addUser(User user) {
		
		String sql="insert into users(first_name,last_name,address,gender,hobby,country) values(?,?,?,?,null,?)";
		Connection con=null;
		try {
			con=dataSource.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,user.getfName());
			ps.setString(2,user.getlName());
			ps.setString(3,user.getAddress());
			ps.setString(4,user.getGender());
			ps.setString(5,user.getCountry());
			ps.execute();
			ps.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		}
				

	}

}
