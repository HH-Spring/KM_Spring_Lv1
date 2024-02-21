package org.sparta.post_lv1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String usetname;
    private String content;
    private String title;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.usetname = post.getUsername();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.password = post.getPassword();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
