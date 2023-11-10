package com.example.prj1be.mapper;

import com.example.prj1be.domain.Member;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO prj1.member(id, password, email)
        VALUES (#{id},#{password},#{email})
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
}
