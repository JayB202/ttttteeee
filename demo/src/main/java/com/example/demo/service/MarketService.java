package com.example.demo.service;
import com.example.demo.dto.MsgDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Market;
import com.example.demo.repository.MarketRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MarketService {
    private final MarketRepository marketRepository;

    @Transactional
    public ResponseDto createBoard(RequestDto requestDto) {
        Market market = new Market(requestDto);
        marketRepository.save(market);
        return new ResponseDto(market);


    }

    @Transactional
    public ResponseDto viewBoard(Long postId) {
        Market market = marketRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("판매글이 존재하지 않습니다.")
        );
        return new ResponseDto(market);
    }

    @Transactional
    public List<ResponseDto> viewBoardList() {
        List<Market> marketList = marketRepository.findAll();
        List<ResponseDto> responseDto = new ArrayList<>();
        for (Market market : marketList) {
            ResponseDto responseDto1 = new ResponseDto(market);
            responseDto.add(responseDto1);
        }
        return responseDto;
    }

    @Transactional
    public ResponseDto updateBoard(Long postId, RequestDto requestDto) {
        Market market = marketRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 판매글 입니다.")
        );
        ResponseDto responseDto = new ResponseDto(market);
        market.update(requestDto);
        return responseDto;
    }


    public MsgDto deleteBoard(Long postId) {
        Market market = marketRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 판매글 입니다.")
        );
        MsgDto msgDto = new MsgDto();
        marketRepository.delete(market);
        msgDto.setMsg("삭제완료");
        return msgDto;
    }
}