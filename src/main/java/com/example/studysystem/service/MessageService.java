package com.example.studysystem.service;

import com.example.studysystem.entity.Message;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {
    Page<Message> findByPage(Integer page, Integer size);
    Message update(Message message);

    Message save(Message message);

    void delete(Integer id);

    List<Message> findByClassInfo_Id(Integer id);
}
