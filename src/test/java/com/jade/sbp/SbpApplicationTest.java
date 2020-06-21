package com.jade.sbp;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jade.sbp.domain.User;
import com.jade.sbp.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
class SbpApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private UserMapper mapper;
	
	
	@Test
	public void testUserMapper() throws Exception {
		User user = mapper.getLoginInfo("admin");
		//System.out.println("User>>" + user);
		//assertEquals("WanSong", user);
		
		String uname = mapper.getUname("Bill");
		System.out.println("uname>>" + uname);
		assertEquals("Bill", uname);
	}
	
	
	@Ignore @Test
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
