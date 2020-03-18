package com.example.studysystem.service.impl;

import com.example.studysystem.entity.Message;
import com.example.studysystem.mapper.MessageMapper;
import com.example.studysystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Misaikun
 * @ClassName MessageServiceImpl
 * @description
 * @date 2020/3/16 21:58
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Page<Message> findByPage(Integer page, Integer size){
        PageRequest of=PageRequest.of(page,size);
        Page<Message> s = messageMapper.findAll(of);
        return s;
    }

    @Override
    public Message update(Message message){
        return messageMapper.save(message);
    }

    @Override
    public Message save(Message message){
        return messageMapper.save(message);
    }

    @Override
    public void delete(Integer id){
        messageMapper.deleteById(id);
    }

    @Override
    public List<Message> findByClassInfo_Id(Integer id){
        return messageMapper.findByClassInfo_Id(id);
    }
}
