package com.example.game.vo;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="tb_rankgame")
public class RankGameVo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rank;
    private String gname;
    private String cate;

    @Builder
    public RankGameVo(int rank, String gname, String cate)
    {
        this.rank = rank;
        this.gname = gname;
        this.cate = cate;
    }
}
