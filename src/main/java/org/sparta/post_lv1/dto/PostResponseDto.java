package org.sparta.post_lv1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.sparta.post_lv1.entity.Post;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)// null값 안보이게
@Getter
public class PostResponseDto {
    private Long id;
    private String username;
    private String content;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String msg;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.content = post.getContent();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

    public PostResponseDto(String msg) {
        this.msg = msg;
    }
}
