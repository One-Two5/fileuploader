package com.example.fileuploader.repository;

import com.example.fileuploader.entity.ForeignAgents;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ForeignAgentRepository {
    private final Connection connection;

    public ForeignAgentRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(ForeignAgents agents) throws SQLException {
        String sql = "INSERT INTO foreigns_agents (full_name, reason, date_included, date_excluded)" +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, agents.getFullName());
            ps.setString(2, agents.getReason());
            ps.setDate(3, Date.valueOf(agents.getDateExcluded()));
            if (agents.getDateExcluded() != null) {
                ps.setDate(4, Date.valueOf(agents.getDateExcluded()));
            } else {
                ps.setNull(4, Types.DATE);
            }
            ps.executeUpdate();
        }
    }

    public List<ForeignAgents> findAll() throws SQLException {
        List<ForeignAgents> list = new ArrayList<>();
        String sql = "SELECT id, full_name, reason, date_included, date-excluded, FROM foreign_agents";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ForeignAgents agents = new ForeignAgents();
                agents.setId(rs.getLong("id"));
                agents.setFullName(rs.getString("full_name"));
                agents.setReason(rs.getString("reason"));
                agents.setDateIncluded(rs.getDate("date_included").toLocalDate());
                Date excludedDate = rs.getDate("date_excluded");
                if (excludedDate != null) {
                    agents.setDateIncluded(excludedDate.toLocalDate());
                }
                list.add(agents);
            }
        }
        return list;
    }
}
