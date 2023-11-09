package com.example.prj1be.mapper;

import com.example.prj1be.domain.Board;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
