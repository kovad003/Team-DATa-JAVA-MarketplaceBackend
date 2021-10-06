package conn;

import java.sql.Connection;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Connections {
	private static DataSource pool=null;
	public static Connection getProductionConnection() throws Exception{
		if (pool!=null) {
			return pool.getConnection();
		}
		// The configuration object specifies behaviors for the connection pool.
		HikariConfig config = new HikariConfig();
		 // Configure which instance and what database user to connect with.
		config.setJdbcUrl(String.format("jdbc:mysql:///%s", System.getProperty("databasename"))); //e.g. hellogoogle1
		config.setUsername(System.getProperty("username")); // e.g. "root", "postgres"
		config.setPassword(System.getProperty("password")); // e.g. "my-password"
		
		  // For Java users, the Cloud SQL JDBC Socket Factory can provide authenticated connections.
		  // See https://github.com/GoogleCloudPlatform/cloud-sql-jdbc-socket-factory for details.
		
		config.addDataSourceProperty("socketFactory",  System.getProperty("sockectfactory"));
		config.addDataSourceProperty("cloudSqlInstance", System.getProperty("cloudsqlinstance"));
		config.addDataSourceProperty("useSSL", "false");
		
		  // ... Specify additional connection properties here.
		  // ...
		  // Initialize the connection pool using the configuration object.
		pool = new HikariDataSource(config);
		  
		Connection conn=null;
		conn = pool.getConnection();
		return conn;
	}
	
	public static Connection getDevConnection() throws Exception{
		if (pool!=null) {
			return pool.getConnection();
		}
		// The configuration object specifies behaviors for the connection pool.
		HikariConfig config = new HikariConfig();
		 // Configure which instance and what database user to connect with.
		config.setDriverClassName(System.getProperty("drivername")); // see appengine-web.xml
		config.setJdbcUrl("jdbc:mysql://localhost:3306/"+System.getProperty("databasename")); // see appengine-web.xml
		config.setUsername(System.getProperty("localusername")); // see appengine-web.xml
		config.setPassword(System.getProperty("localpassword")); // see appengine-web.xml
		
		  // Initialize the connection pool using the configuration object.
		pool = new HikariDataSource(config);
		  
		Connection conn=null;
		conn = pool.getConnection();
		return conn;
	}
}
