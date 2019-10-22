package cn.test.forum.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String avatar_url;

}
