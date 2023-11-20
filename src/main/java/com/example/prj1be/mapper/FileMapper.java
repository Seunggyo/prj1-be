package com.example.prj1be.mapper;

import com.example.prj1be.domain.BoardFile;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FileMapper {

    @Insert("""
        INSERT INTO boardFile (boardId, name)
        VALUES (#{boardId}, #{name})
        """)
    int insert(Integer boardId, String name);

    @Select("""
        SELECT id, name
        FROM boardFile
        WHERE boardId = #{boardId}
        """)
    List<BoardFile> selectNamesByBoardId(Integer boardId);
}
