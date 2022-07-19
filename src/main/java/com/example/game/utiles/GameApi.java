package com.example.game.utiles;

// 네이버 검색 API 예제 - blog 검색
import com.example.game.dto.TbRankGame;
import com.example.game.vo.RankGameVo;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameApi
{
    public static List<TbRankGame> getRankGameList()
    {
        final String stockList  = "https://www.gamemeca.com/ranking.php?scode=O";
        Connection conn = Jsoup.connect(stockList);
        List<TbRankGame> list = new ArrayList<>();

        try
        {
            Document document = conn.get();
//            String thead = getStockHeader(document); // 칼럼명
            Elements stockTableBody = document.select("div.content-left");
            List<String> gnameList = new ArrayList<>();
            int rank = 1;

            for (Element element : stockTableBody.select("div.game-name"))
            {
                String gname = element.select("a").text();   // 노래 제목
                gnameList.add(gname);
                System.out.println((rank++) + ": " + gname);
            }
            rank = 1;
            for (Element element : stockTableBody.select("div.game-info span.company"))
            {
                String cate = element.select("a").text();   // 노래 제목
                TbRankGame dto = new TbRankGame();
                dto.setGname(gnameList.get(rank-1));
                dto.setCate(cate);
                dto.setRank(rank);
                list.add(dto);
                System.out.println((rank++) + ": " + cate);
            }
        }
        catch (IOException ignored)
        {

        }
        return list;
    }
}
