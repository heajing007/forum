package cn.test.forum.mapper;

import cn.test.forum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name, accountId, token, gmt_create, gmt_modified) values(#{name},#{accountId}, #{token}, #{gmt_create}, #{gmt_modified})")
    void insert(User user);
}
