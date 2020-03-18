package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Score;
import com.example.studysystem.mapper.ScoreMapper;
import com.example.studysystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName ScoreServiceImpl
 * @description
 * @date 2020/3/17 16:33
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Page<Score> findByPage(Integer page, Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Score> s = scoreMapper.findAll(of);
        return s;
    }

    @Override
    public Score save(Score score){
        return scoreMapper.save(score);
    }

    @Override
    public Score update(Score score){
        return scoreMapper.save(score);
    }

    @Override
    public void delete(Integer id){
        scoreMapper.existsById(id);
    }

    @Override
    public List<Score> findByExamination_Id(Integer id){
        return scoreMapper.findByExamination_Id(id);
    }

    @Override
    public List<Score> findByStudent_Id(Integer id){
        return scoreMapper.findByStudent_Id(id);
    }

    @Override
    public List<Score> findByStudent_IdAndAndExamination_Id(Integer sid,Integer eid){
        return scoreMapper.findByStudent_IdAndAndExamination_Id(sid,eid);
    }
}
