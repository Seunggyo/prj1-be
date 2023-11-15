package com.example.prj1be.mapper;

import com.example.prj1be.domain.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    @Insert("""
        INSERT INTO comment(boardId, comment,memberId)
        VALUES (#{boardId},#{comment},#{memberId})
        """)
    int insert(Comment comment);

    @Select("""
        SELECT *
        FROM prj1.comment
        WHERE boardId = #{boardId}
        """)
    List<Comment> selectByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM prj1.comment
        WHERE id = #{id}
        """)
    int deleteById(Integer id);

    @Select("""
        SELECT c.memberId , m.id
        FROM prj1.comment c join prj1.member m on m.id = c.memberId
        WHERE c.id = #{id}
        """)
    Comment selectById(Integer id);
}
