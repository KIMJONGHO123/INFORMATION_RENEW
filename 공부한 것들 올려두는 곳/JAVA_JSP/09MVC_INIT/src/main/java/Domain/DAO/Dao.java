package Domain.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Domain.DAO.ConnectionPool.ConnectionItem;
import Domain.DAO.ConnectionPool.ConnectionPool;



public abstract class Dao {
	
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	protected ConnectionPool connectionPool;
	protected ConnectionItem connectionItem;
	public Dao() throws Exception{
		//connectionPool
		connectionPool =ConnectionPool.getInstance();
	}
	
}
