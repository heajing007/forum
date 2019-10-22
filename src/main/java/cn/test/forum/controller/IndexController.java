package cn.test.forum.controller;

import cn.test.forum.dto.PaginationDTO;
import cn.test.forum.mapper.UserMapper;
import cn.test.forum.model.User;
import cn.test.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name="page", defaultValue = "1")Integer page,
                        @RequestParam(name="size", defaultValue = "7")Integer size){
//        Cookie[] cookies= request.getCookies();
//        for (Cookie cookie : cookies){
//            if("token".equals(cookie.getName())){
//                String token = cookie.getValue();
//                User user = userMapper.findByToken(token);
//                System.out.println(user);
//                if(user != null){
//                    request.getSession().setAttribute("user", user);
//                }
//                break;
//            }
//        }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}


