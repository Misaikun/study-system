package com.example.studysystem.mapper;

import com.example.studysystem.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreMapper extends JpaRepository<Score,Integer> {
    List<Score> findByExamination_Id(Integer id);

    List<Score> findByStudent_Id(Integer id);

    List<Score> findByStudent_IdAndAndExamination_Id(Integer sid,Integer eid);
}
