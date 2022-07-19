package com.example.game.service;

import com.example.game.dto.TbRankGame;
import com.example.game.repo.GameRepository;
import com.example.game.repo.RankGameRepository;
import com.example.game.utiles.GameApi;
import com.example.game.utiles.NaverApi;
import com.example.game.vo.GameVo;
import com.example.game.vo.RankGameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankGameService
{
    @Autowired
    private RankGameRepository rankGameRepository;

    public List<RankGameVo> findAll()
    {
        List<RankGameVo> rankgame = new ArrayList<>();
        rankGameRepository.findAll().forEach(e -> rankgame.add(e));
        return rankgame;
    }

    // 데이터 넣기(insert)
    public Long save(RankGameVo rankgame)
    {
        return rankGameRepository.save(rankgame).getId();
    }

    // 멜론 차트를 크롤링 해서 리스트를 전달
    public List<TbRankGame> getRankGameList()
    {
        return GameApi.getRankGameList();
    }

}

