package com.example.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTestApplicationTests
{

    private String url = "jdbc:mysql://localhost:3306/test";
    private String user = "root";
    private String password = "123";
    private Connection connection;

    @Before
    public void contextLoads()
    {
	try
	{
	    Class.forName("com.mysql.jdbc.Driver");

	    connection = DriverManager.getConnection(url, user, password);

	} catch (Exception e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void demo()
    {

	try
	{
	    Statement stmt = connection.createStatement();

	    ResultSet rl = stmt.executeQuery("select dept_id,name from sys_dept");

	    while (rl.next())
	    {
		System.out.println("*****" + rl.getInt("dept_id") + "******" + rl.getString("name"));
	    }

	} catch (SQLException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
