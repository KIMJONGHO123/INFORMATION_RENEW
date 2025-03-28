package Ch38Domain.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Ch38Domain.Dao.ConnectionPool.ConnectionItem;
import Ch38Domain.Dao.ConnectionPool.ConnectionPool;

public abstract class Dao {
	
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	
	protected ConnectionPool connectionpool;
	protected ConnectionItem connectionitem;
	
	public Dao() throws Exception{
		// connectionPool
		connectionpool = ConnectionPool.getInstance();
		
	}
}
