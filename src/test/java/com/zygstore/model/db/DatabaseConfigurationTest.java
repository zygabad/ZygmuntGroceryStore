package com.zygstore.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Place description here.
 *
 * @author Y08L@nykredit.dk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/com/zygstore/model/db/memoryDBTestContext.xml")
public class DatabaseConfigurationTest {

    @Test
    public void testDatabsaseRunning() throws SQLException {
        //given
        String url = "jdbc:hsqldb:mem:zygstoreDB";
        String user = "sa";
        String password = "sa";

        //when
        Connection connection = DriverManager.getConnection(url, user, password);

        //then
        assertFalse(connection.isClosed());
    }

}