package org.c3s.edgo.scripts.check;

public class JDBCTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties props = new Properties();
		props.put("useServerPrepStmts", "true");
		//props.put("password", "root");
		//props.put("retainStatementAfterResultSetClose", true);
		props.put("user", "hapsys");
		props.put("password", "123467890");
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.10:3306/ed-go", props);
		PreparedStatement stmp = connection.prepareStatement("SELECT * FROM events_history WHERE user_id=?  AND  event_timestamp=?  AND  event_hash=?");
		ResultSetMetaData md = stmp.getMetaData();
		System.out.println(md.getColumnCount());
		*/
		
		//System.out.println(Long.class.isAssignableFrom(Integer.class));
		//System.out.println(ClassUtils.isAssignable(Long.class, Integer.class, true));
	}

}
