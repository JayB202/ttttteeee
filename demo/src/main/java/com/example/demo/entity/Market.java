package com.example.demo.entity;
import com.example.demo.dto.RequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;

    public Market(RequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.price = requestDto.getPrice();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    public void update(RequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.price = requestDto.getPrice();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();

    }
}
