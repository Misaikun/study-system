package com.example.studysystem.mapper;

import com.example.studysystem.entity.ClassInfo;
import com.example.studysystem.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName MessageMapper
 * @description
 * @date 2020/3/16 15:12
 */
public interface MessageMapper extends JpaRepository<Message,Integer> {
    List<Message> findByClassInfo_Id(Integer id);
}
