package answer.logic.Util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

    private static final String JNDI_NAME = "java:comp/env/jdbc/mysql";

    public static Connection getConnection() {

	InitialContext context = null;
	Connection con = null;

	try {
	    context = new InitialContext();
	    DataSource ds = (DataSource) context.lookup(JNDI_NAME);

	    con = ds.getConnection();
	} catch (NamingException | SQLException e) {
	    throw new RuntimeException("データソースが取得できませんでした");
	} finally {
	    if (context != null) {
		try {
		    context.close();
		} catch (NamingException e) {
		    throw new RuntimeException("データソースが取得できませんでした");
		}
	    }
	}
	return con;

    }

}
