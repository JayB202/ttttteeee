package com.example.demo.controller;


import com.example.demo.dto.MsgDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MarketController {
    private final MarketService marketService;

    @PostMapping("/post")
    public ResponseDto createBoard(@RequestBody RequestDto requestDto){
        return marketService.createBoard(requestDto);
    }

    @GetMapping("/post/{postId}")
    public ResponseDto viewBoard(@PathVariable Long postId){
        return marketService.viewBoard(postId);
    }

    @GetMapping("/post")
    public List<ResponseDto> viewBoardList(){
        return marketService.viewBoardList();
    }

    @PutMapping("/post/{postId}")
    public ResponseDto updateBoard(@PathVariable Long postId, @RequestBody RequestDto requestDto){
        return marketService.updateBoard(postId, requestDto);
    }

    @DeleteMapping("/posts/{postId}")
    public MsgDto deleteBoard(@PathVariable Long postId){
        return marketService.deleteBoard(postId);
    }
}
