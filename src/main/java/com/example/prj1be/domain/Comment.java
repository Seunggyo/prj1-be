package com.example.prj1be.domain;

import com.example.prj1be.util.AppUtil;
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

    public String getAgo() {
        return AppUtil.getAgo(inserted, LocalDateTime.now());
    }
}
