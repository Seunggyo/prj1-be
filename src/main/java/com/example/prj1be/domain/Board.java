package com.example.prj1be.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Board {

    private Integer id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime inserted;
    private String nickName;
    private Integer countComment;
    private Integer countLike;
}
