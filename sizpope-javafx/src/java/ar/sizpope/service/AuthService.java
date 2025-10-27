package ar.sizpope.service;

import ar.sizpope.domain.User;
import ar.sizpope.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    private final UserRepository users;
    public AuthService(UserRepository users){ this.users = users; }

    public User login(String email, String password) throws Exception {
        User u = users.findByEmail(email);
        if (u == null) throw new IllegalArgumentException("Usuario no encontrado");
        if (!"ACTIVE".equals(u.getStatus())) throw new IllegalStateException("Usuario inactivo");
        if (!BCrypt.checkpw(password, u.getPasswordHash())) throw new SecurityException("Credenciales inválidas");
        return u;
    }
}

