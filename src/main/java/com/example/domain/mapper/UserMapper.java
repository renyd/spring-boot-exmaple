package com.example.domain.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Domg on 2016/11/20.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User selectByPrimaryKey(Long id);

    @Insert("insert into user (`userName`,`age`,`state`,`updateTime`,`createTime`) values('#{user.userName}','#{user.age}','#{user.state}',now(),now())")
    public int insert(User user);

}
