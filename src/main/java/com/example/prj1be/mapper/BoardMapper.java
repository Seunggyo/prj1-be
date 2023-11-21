package com.example.prj1be.mapper;

import com.example.prj1be.domain.Board;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

    @Insert("""
        INSERT INTO prj1.board(title, content, writer)
        VALUES (#{title},#{content},#{writer})
        """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("""
        SELECT b.id,
               b.title,
               m.nickName,
               b.writer,
               b.inserted,        
               COUNT(DISTINCT c.id) countComment,
               COUNT(DISTINCT bL.id) countLike,
               COUNT(DISTINCT bF.id) countFile
        FROM prj1.board b join prj1.member m on m.id = b.writer
            LEFT JOIN prj1.comment c on b.id = c.boardId
            LEFT JOIN prj1.boardLike bL on b.id = bL.boardId
            LEFT JOIN prj1.boardFile bF on b.id = bF.boardId
        WHERE b.content LIKE  #{keyword}
        OR b.title LIKE #{keyword}
        GROUP BY b.id
        ORDER BY b.id DESC
        LIMIT #{from},10
        """)
    List<Board> selectAll(Integer from, String keyword);

    @Select("""
        SELECT b.id,b.title,b.content,m.nickName,b.writer,b.inserted
        FROM prj1.board b join prj1.member m on m.id = b.writer
        WHERE b.id = #{id}
        """)
    Board selectById(Integer id);

    @Delete("""
        DELETE FROM prj1.board
        WHERE id =#{id}
        """)
    int deleteById(Integer id);

    @Update("""
        UPDATE prj1.board
        SET title =#{title},
        content = #{content},
        writer = #{writer}
        WHERE id = #{id}
        """)
    int update(Board board);

    @Delete("""
        DELETE FROM board
        WHERE writer =#{writer}
        """)
    int deleteByWriter(String writer);

    @Select("""
        SELECT id
        FROM board
        WHERE writer = #{writer}
        """)
    List<Integer> selectIdListByMemberId(String writer);

    @Select("""
        SELECT COUNT(*)
        FROM board
        WHERE title LIKE #{keyword}
        OR content LIKE #{keyword}
        """)
    int countAll(String keyword);
}
