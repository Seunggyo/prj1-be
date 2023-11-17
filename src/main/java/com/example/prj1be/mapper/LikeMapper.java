package com.example.prj1be.mapper;

import com.example.prj1be.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LikeMapper {

    @Delete("""
        DELETE FROM prj1.boardLike
        WHERE boardId = #{boardId}
        AND memberId = #{memberId}
        """)
    int delete(Like like);

    @Insert("""
        INSERT INTO prj1.boardLike(boardId, memberId)
        VALUES (#{boardId},#{memberId})
        """)
    int insert(Like like);

    @Select("""
        SELECT COUNT(id)
        FROM prj1.boardLike
        WHERE boardId = #{boardId}
        """)
    int countByBoardId(Integer boardId);

    @Select("""
        SELECT *
        FROM prj1.boardLike
        WHERE boardId =#{boardId}
        AND memberId = #{memberId}
        """)
    Like seletByBoardIdAndMemberId(Integer boardId, String memberId);
}
