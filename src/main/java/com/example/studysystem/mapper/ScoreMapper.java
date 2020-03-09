package com.example.studysystem.mapper;

import com.example.studysystem.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreMapper extends JpaRepository<Score,Integer> {
}
