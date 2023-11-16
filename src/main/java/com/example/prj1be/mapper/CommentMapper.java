package com.example.prj1be.mapper;

import com.example.prj1be.domain.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentMapper {

    @Insert("""
        INSERT INTO comment(boardId, comment,memberId)
        VALUES (#{boardId},#{comment},#{memberId})
        """)
    int insert(Comment comment);

    @Select("""
        SELECT c.id,
        c.comment,
        c.inserted,
        c.boardId,
        c.memberId,
        m.nickName memberNickName
        FROM prj1.comment c JOIN prj1.member m on m.id = c.memberId
        WHERE boardId = #{boardId}
        """)
    List<Comment> selectByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM comment
        WHERE id = #{id}
        """)
    int deleteById(Integer id);

    @Select("""
        SELECT *
        FROM comment
        WHERE id = #{id}
        """)
    Comment selectById(Integer id);

    @Update("""
        UPDATE prj1.comment
        SET comment =#{comment}
        WHERE id = #{id}
        """)
    int update(Comment comment);

    @Delete("""
        DELETE FROM comment
        WHERE boardId = #{boardId}
        """)
    int deleteByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM comment
        WHERE memberId = #{memberId}
        """)
    int deleteByMemberId(String memberId);
}
