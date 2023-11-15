package com.example.prj1be.service;

import com.example.prj1be.domain.Comment;
import com.example.prj1be.domain.Member;
import com.example.prj1be.mapper.CommentMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper mapper;
    private final MemberService memberService;

    public boolean add(Comment comment, Member login) {
        comment.setMemberId(login.getId());
        return mapper.insert(comment) == 1;
    }

    public boolean validate(Comment comment) {
        if (comment == null) {

            return false;
        }
        if (comment.getBoardId() == null || comment.getBoardId() < 1) {
            return false;
        }
        if (comment.getComment() == null || comment.getComment().isBlank()) {
            return false;
        }
        return true;
    }

    public List<Comment> list(Integer boardId) {
        return mapper.selectByBoardId(boardId);
    }

    public boolean remove(Integer id) {
        return mapper.deleteById(id) == 1;
    }

    public boolean hasAccess(Integer id, Member login) {
        if (memberService.isAdmin(login)) {
            return true;
        }
        Comment comment = mapper.selectById(id);

        return comment.getMemberId().equals(login.getId());

    }
}
