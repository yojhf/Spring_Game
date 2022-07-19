package com.example.game.service;

import com.example.game.repo.GameRepository;
import com.example.game.utiles.NaverApi;
import com.example.game.vo.GameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService
{
    @Autowired
    private GameRepository gameRepository;
    public String blogSearch(String keyword)
    {
        return NaverApi.blogSearch(keyword);
    }

    // 전체 데이터 조회
    public List<GameVo> findAll()
    {
        List<GameVo> game = new ArrayList<>();
        gameRepository.findAll().forEach(e -> game.add(e));
        return game;
    }
    // 데이터 넣기(insert)
    public Long save(GameVo game)
    {
        return gameRepository.save(game).getId();
    }
    public List<GameVo> findRandMenu()
    {
        return gameRepository.findRandMenu();
    }


}

