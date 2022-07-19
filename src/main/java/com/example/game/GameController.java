package com.example.game;


import com.example.game.dto.TbGame;

import com.example.game.service.GameService;
import com.example.game.service.RankGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController
{
    @Autowired
    private GameService gameService;
    @Autowired
    private RankGameService rankgameService;


    @GetMapping("/")
    public String index()
    {
        return "index";
    }
    @GetMapping("/blog")
    public String blog()
    {
        return "blog";
    }
    @GetMapping("/insert")
    public String insert()
    {
        return "insert";
    }
    @GetMapping("/see")
    public String see(Model model)
    {
        model.addAttribute("list", gameService.findAll());
        return "see";
    }
    @GetMapping("/best")
    public String best()
    {
        return "best";
    }
    @GetMapping("/rankgame")
    public String melon(Model model)
    {
        model.addAttribute("list", rankgameService.getRankGameList());
        return "rankgame";
    }

    @PostMapping("/insert_proc")
    @ResponseBody
    public TbGame insert_proc(@ModelAttribute TbGame tbgame)
    {
        System.out.println(tbgame.getName());
        System.out.println(tbgame.getJang());
        System.out.println(tbgame.getPage());
        System.out.println(tbgame.getImg());
        return tbgame;
    }
}
