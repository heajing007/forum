package cn.test.forum.dto;

import cn.test.forum.model.User;
import lombok.Data;

//DTO传输层
@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private int creator;
    private int comment_count;
    private int view_count;
    private int like_count;
    private String tag;
    private User user;


}
