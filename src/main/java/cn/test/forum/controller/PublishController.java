package cn.test.forum.controller;

import cn.test.forum.mapper.QuestionMapper;
import cn.test.forum.mapper.UserMapper;
import cn.test.forum.model.Question;
import cn.test.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/publish")
    public String publish(){


        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(@RequestParam("title")String title,
                            @RequestParam("description")String description,
                            @RequestParam("tag")String tag,
                            HttpServletRequest request,
                            Model model){

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if(title == null || title == ""){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }


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
        if(user == null){
            model.addAttribute("error", "用户未登录");
            return "publish";
        }

        Question question = new Question();

        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());
        questionMapper.create(question);


        return "redirect:/";
    }

}
