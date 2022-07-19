package com.example.game.vo;

import lombok.*;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="tb_game")
public class GameVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String jang;
    private String page;
    private String img;

    @Builder
    public GameVo(String name, String jang, String page, String img) {
        this.name = name;
        this.jang = jang;
        this.page = page;
        this.img = img;
    }
}