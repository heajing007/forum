package cn.test.forum.controller;

import cn.test.forum.dto.PaginationDTO;
import cn.test.forum.mapper.UserMapper;
import cn.test.forum.model.Question;
import cn.test.forum.model.User;
import cn.test.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name="action")String action, Model model,
                          @RequestParam(name="page", defaultValue = "1")Integer page,
                          @RequestParam(name="size", defaultValue = "7")Integer size){

//        User user = null;
//        Cookie[] cookies= request.getCookies();
//        for (Cookie cookie : cookies){
//            if("token".equals(cookie.getName())){
//                String token = cookie.getValue();
//                user = userMapper.findByToken(token);
//                System.out.println(user);
//                if(user != null){
//                    request.getSession().setAttribute("user", user);
//                }
//                break;
//            }
//        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }

        if("questions".equals(action)){
            model.addAttribute("action","questions");
            model.addAttribute("sectionName","我的提问");
        }else if("replies".equals(action)){
            model.addAttribute("action","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);
        return "profile";
    }

}
