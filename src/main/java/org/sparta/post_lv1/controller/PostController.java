package org.sparta.post_lv1.controller;

import org.sparta.post_lv1.dto.PostRequestDto;
import org.sparta.post_lv1.dto.PostResponseDto;
import org.sparta.post_lv1.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

//    @GetMapping("/post/{postId}")
//    public Long getPost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.getPost(id, requestDto);
//    }
//
//    @GetMapping("/posts/{postId}")
//    public Long getPosts(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.getPosts(id, requestDto);
//    }
//
//    @PutMapping("/post/{postId}")
//    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
//        return postService.updatePost(id, requestDto);
//    }
//
//    @DeleteMapping("/post/{postId}")
//    public Long deletePost(@PathVariable Long id) {
//        return postService.deletePost(id);
//    }
}
