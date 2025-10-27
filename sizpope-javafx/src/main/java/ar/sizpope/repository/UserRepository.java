package ar.sizpope.repository;

import ar.sizpope.config.Db;
import ar.sizpope.domain.User;

import java.sql.*;

public class UserRepository {
    public User findByEmail(String email) throws SQLException {
        String sql = "SELECT id,email,password_hash,status,display_name FROM auth_user WHERE email=?";
        try (Connection c = Db.get();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("id"),
                            rs.getString("email"),
                            rs.getString("password_hash"),
                            rs.getString("status"),
                            rs.getString("display_name")
                    );
                }
                return null;
            }
        }
    }
}

