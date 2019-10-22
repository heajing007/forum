package cn.test.forum.service;

import cn.test.forum.mapper.UserMapper;
import cn.test.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user){
        User dbUser = userMapper.findByAccountId(user.getAccountId());

        if (dbUser == null){
            //插入
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);
            System.out.println(user);
            System.err.println("授权登录成功");
        }else{
            //更新
            dbUser.setGmt_modified(System.currentTimeMillis());
            dbUser.setAvatar_url(user.getAvatar_url());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
            System.out.println("user: "+user);
            System.out.println("dbUser: "+dbUser);
            System.err.println("登录成功");
        }

    }

}
