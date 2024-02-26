package org.sparta.post_lv1.controller;

import org.sparta.post_lv1.dto.PostRequestDto;
import org.sparta.post_lv1.dto.PostResponseDto;
import org.sparta.post_lv1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/post/{postId}") // 해당 게시물 상세조회 Long 타입 아님
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/post")
    public List<PostResponseDto> getFindAllPosts() {
        return postService.getFindAllPosts();
    }

    @PutMapping("/post/{postId}")
    public PostResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(postId, requestDto);
    }

    @DeleteMapping("/post/{postId}")
    public PostResponseDto deletePost(@PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        return postService.deletePost(postId, requestDto);
    }
}
