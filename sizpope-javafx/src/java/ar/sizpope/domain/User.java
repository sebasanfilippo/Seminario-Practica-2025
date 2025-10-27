package ar.sizpope.domain;

import java.util.UUID;

public class User {
    private String id;
    private String email;
    private String passwordHash;
    private String status;
    private String displayName;

    public User(String id, String email, String passwordHash, String status, String displayName) {
        this.id = id; this.email = email; this.passwordHash = passwordHash;
        this.status = status; this.displayName = displayName;
    }
    public static String newId(){ return UUID.randomUUID().toString(); }

    public String getId(){ return id; }
    public String getEmail(){ return email; }
    public String getPasswordHash(){ return passwordHash; }
    public String getStatus(){ return status; }
    public String getDisplayName(){ return displayName; }
}

