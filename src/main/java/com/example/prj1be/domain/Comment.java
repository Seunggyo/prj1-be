package com.example.prj1be.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Comment {

    private Integer id;
    private Integer boardId;
    private String memberId;
    private String comment;
    private LocalDateTime inserted;
    private String MemberNickName;
}
