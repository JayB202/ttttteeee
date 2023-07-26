package com.example.demo.dto;
import com.example.demo.entity.Market;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;
    public ResponseDto(Market market) {
        this.id = market.getId();
        this.title = market.getTitle();
        this.content = market.getContent();
        this.price = market.getPrice();
        this.username = market.getUsername();
    }
}
