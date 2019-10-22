package cn.test.forum;

import cn.test.forum.mapper.QuestionMapper;
import cn.test.forum.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumApplicationTests {

    @Autowired
    QuestionMapper questionMapper;

    @Test
    public void contextLoads() {

        for (int i=0; i<100; i++){
            Question question = new Question();
            question.setTitle(i+"asdf");
            question.setDescription(i+"asdfasf");
            question.setTag(i+"");
            question.setCreator(30);
            question.setGmt_create(System.currentTimeMillis());
            question.setGmt_modified(question.getGmt_create());
            questionMapper.create(question);
        }
    }

}
