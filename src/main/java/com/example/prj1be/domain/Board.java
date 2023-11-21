package com.example.prj1be.domain;

import com.example.prj1be.util.AppUtil;
import java.time.LocalDateTime;
import java.util.List;
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
    private Integer countFile;
    private List<BoardFile> files;


    public String getAgo() {
        return AppUtil.getAgo(inserted, LocalDateTime.now());
    }

}

