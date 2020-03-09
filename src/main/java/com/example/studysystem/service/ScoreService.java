package com.example.studysystem.service;

import com.example.studysystem.entity.Score;
import org.springframework.data.domain.Page;

public interface ScoreService {
    Page<Score> findByPage(Integer page,Integer size);

    Score save(Score score);

    Score update(Score score);

    void delete(Integer id);
}
