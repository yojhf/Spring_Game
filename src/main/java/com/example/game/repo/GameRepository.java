package com.example.game.repo;

import com.example.game.vo.GameVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<GameVo, Long>
{
    @Query(value = "SELECT * FROM tb_game ORDER BY RAND() LIMIT 1", nativeQuery=true)
    List<GameVo> findRandMenu();
}
