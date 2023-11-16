package com.example.prj1be.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Member {

    private String id;
    private String password;
    private String email;
    private String nickName;
    private LocalDateTime inserted;
    private List<Auth> auth;

    public boolean isAdmin() {
        if (auth != null) {
            return auth.stream()
                .map(a -> a.getName())
                .anyMatch(n -> n.equals("admin"));
        }
        return false;
    }
}
