package com.example.game.repo;

import com.example.game.vo.GameVo;
import com.example.game.vo.RankGameVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankGameRepository extends JpaRepository<RankGameVo, Long>
{

}
