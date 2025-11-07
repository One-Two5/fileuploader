package com.example.fileuploader.repository;

import com.example.fileuploader.entity.ForeignAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ForeignAgentRepository {
    private final JdbcTemplate jdbcTemplate;

    public ForeignAgentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ForeignAgent agent) {
        jdbcTemplate.update
                ("INSERT INTO foreign_agent (full_name, reason, date_included, date_excluded) VALUES (?, ?, ?, ?)",
                 agent.getFullName(),
                 agent.getReason(),
                 agent.getDateIncluded(),
                 agent.getDateExcluded()
        );
    }

    public List<ForeignAgent> findAll() {
        String sql = "SELECT id, full_name, reason, date_included, date_excluded FROM foreign_agent";
        return jdbcTemplate.query(sql, new ForeignAgentMapper());
    }

    private static class ForeignAgentMapper implements RowMapper<ForeignAgent> {
        @Override
        public ForeignAgent mapRow(ResultSet rs, int rowNum) throws SQLException {
            ForeignAgent agent = new ForeignAgent();
            agent.setId(rs.getLong("id"));
            agent.setFullName(rs.getString("full_name"));
            agent.setReason(rs.getString("reason"));
            agent.setDateIncluded(rs.getObject("date_included", LocalDate.class));
            agent.setDateExcluded(rs.getObject("date_excluded", LocalDate.class));
            return agent;
        }
    }
}
