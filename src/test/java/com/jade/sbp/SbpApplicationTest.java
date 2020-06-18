package com.jade.sbp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbpApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println("DS=" + ds);	
		try (Connection conn = ds.getConnection()){				
			System.out.println("########" +getLong(conn, "select 99999999"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	void contextLoads() {

	}
	
	
	private Object getLong(Connection conn, String sql) {
		long result = 0;
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				result = rs.getLong(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
