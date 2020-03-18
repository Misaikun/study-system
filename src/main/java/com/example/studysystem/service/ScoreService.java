package com.example.studysystem.service;

import com.example.studysystem.entity.Score;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ScoreService {
    Page<Score> findByPage(Integer page,Integer size);

    Score save(Score score);

    Score update(Score score);

    void delete(Integer id);

    List<Score> findByExamination_Id(Integer id);

    List<Score> findByStudent_Id(Integer id);

    List<Score> findByStudent_IdAndAndExamination_Id(Integer sid,Integer eid);
}
