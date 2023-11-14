package com.example.prj1be.mapper;

import com.example.prj1be.domain.Board;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

    @Insert("""
        INSERT INTO prj1.board(title, content, writer)
        VALUES (#{title},#{content},#{writer})
        """)
    int insert(Board board);

    @Select("""
        SELECT id,title,writer,inserted
        FROM prj1.board 
        ORDER BY id DESC 
        """)
    List<Board> selectAll();

    @Select("""
        SELECT *
        FROM prj1.board
        WHERE id = #{id}
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
}
