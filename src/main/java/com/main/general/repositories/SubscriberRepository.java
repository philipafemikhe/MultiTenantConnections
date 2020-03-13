package com.main.general.repositories;

import com.main.general.entities.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class SubscriberRepository {
    @Autowired
    private JdbcTemplate jdbcTemplateMain;

    public void insert(Subscriber subscriber){
        String sql = "INSERT INTO SUBSCRIBER " + "(id, subscriberName, company, databaseName) VALUES(?,?,?,?)";
        System.out.println(sql);
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplateMain.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, String.valueOf(subscriber.getId()));
                ps.setString(2,subscriber.getSubscriberName());
                ps.setString(3, subscriber.getCompany());
                ps.setString(4,subscriber.getDatabaseName());
                return ps;
            }
        }, holder);
//        int generatedSubscriberId = holder.getKey().intValue();
//        System.out.println("Generated subscriber id = " + generatedSubscriberId);
    }
}
