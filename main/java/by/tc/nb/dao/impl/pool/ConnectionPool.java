package by.tc.nb.dao.impl.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	private static final ConnectionPool instance = new ConnectionPool();
	
	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(5);

	private ConnectionPool() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			for(int index = 0; index < pool.remainingCapacity(); index++) {
				pool.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/notebook?useSSL=false","root","mysql"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws InterruptedException{
		return pool.take();
	}
	
	public void returnConnection(Connection connection) throws SQLException, InterruptedException{
		if(connection == null){
			return;
		}
		connection.setAutoCommit(true);
		connection.setReadOnly(false);
		
		pool.put(connection);
	}
	
	public void closePool(){
		
		for(Connection con : pool){
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
		
	}
	
	public static ConnectionPool getInstance(){
		return instance;
	}

}
