package com.example.prj1be.mapper;

import com.example.prj1be.domain.Auth;
import com.example.prj1be.domain.Member;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO prj1.member(id, password, email, nickName)
        VALUES (#{id},#{password},#{email}, #{nickName})
        """)
    int insert(Member member);

    @Select("""
        SELECT id
        FROM prj1.member
        WHERE id = #{id}
        """)
    String selectId(String id);

    @Select("""
        SELECT email
        FROM prj1.member
        WHERE email = #{email}
        """)
    String selectEmail(String email);

    @Select("""
        SELECT *
        FROM prj1.member
        ORDER BY inserted DESC 
        """)
    List<Member> selectAll();

    @Delete("""
        DELETE FROM prj1.member
        WHERE id=#{id}
        """)
    int deleteById(String id);

    @Select("""
        SELECT *
        FROM prj1.member
        WHERE id = #{id}
                                """)
    Member selectById(String id);

    @Update("""
        <script>
        UPDATE prj1.member
        SET 
          <if test="password != ''">
          password = #{password},
          </if>
          email = #{email},
          nickName = #{nickName}
        WHERE id = #{id}
        </script>
        """)
    int update(Member member);

    @Select("""
        SELECT nickName
        FROM prj1.member
        WHERE nickName = #{nickName}
        """)
    String selectNickName(String nickName);

    @Select("""
        SELECT *
        FROM prj1.auth
        WHERE memberId = #{id}
        """)
    List<Auth> selectAuthById(String id);
}
