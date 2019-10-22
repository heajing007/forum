package cn.test.forum.mapper;

import cn.test.forum.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name, accountId, token, gmt_create, gmt_modified, avatar_url) values(#{name},#{accountId}, #{token}, #{gmt_create}, #{gmt_modified}, #{avatar_url})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token")String token);//传入的值不是类(User)时要用@Param("xxx")

    @Select("select * from user where accountId=#{id}")
    User findByAccountId(@Param("id") String id);

    @Select("select * from user where id=#{creator}")
    User findById(@Param("creator") Integer creator);

    @Update("update user set name=#{name}, token=#{token}, gmt_modified=#{gmt_modified}, avatar_url=#{avatar_url} where accountId=#{accountId}")
    Integer update(User user);
}