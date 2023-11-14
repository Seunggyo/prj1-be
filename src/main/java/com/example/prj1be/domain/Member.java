package com.example.prj1be.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Member {

    private String id;
    private String password;
    private String email;
    private String nickName;
    private LocalDateTime inserted;
}
