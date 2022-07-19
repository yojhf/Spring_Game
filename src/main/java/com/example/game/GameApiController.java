package com.example.game;
import com.example.game.dto.TbRankGame;
import com.example.game.service.GameService;
import com.example.game.service.RankGameService;
import com.example.game.vo.GameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameApiController
{
    @Autowired
    private GameService gameService;
    @Autowired
    private RankGameService rankgameService;

    @GetMapping("/api/v1/blogmenu")
    public ResponseEntity<String> getBlog(@RequestParam String keyword)
    {
        String json = gameService.blogSearch(keyword);
        return new ResponseEntity<String>(json, HttpStatus.OK);
    }
    @PostMapping("/api/v1/insert")
    public Long save(@RequestBody GameVo gamevo)
    {
        return gameService.save(gamevo);
    }
    @GetMapping("/gamelist")
    public ResponseEntity<List<GameVo>> getAllMenu()
    {
        List<GameVo> list = gameService.findAll();
        return new ResponseEntity<List<GameVo>>(list, HttpStatus.OK);
    }
    @GetMapping("/api/v1/bestgame")
    public ResponseEntity<List<GameVo>> getRandMenu()
    {
        List<GameVo> list = gameService.findRandMenu();
        return new ResponseEntity<List<GameVo>>(list, HttpStatus.OK);
    }
    @GetMapping("/api/v1/rankgame")
    public ResponseEntity<List<TbRankGame>> getRankGameList()
    {
        List<TbRankGame> list = rankgameService.getRankGameList();
        return new ResponseEntity<List<TbRankGame>>(list, HttpStatus.OK);
    }

}
