package com.example.prj1be.mapper;

import com.example.prj1be.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO prj1.member(id, password, email)
        VALUES (#{id},#{password},#{email})
        """)
    int insert(Member member);
}
