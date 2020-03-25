package com.example.studysystem.mapper;

import com.example.studysystem.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerMapper extends JpaRepository<Answer,Integer> {
    List<Answer> findByStudent_Id(Integer id);

    List<Answer> findAnswersByExaminationContent_Id(Long id);//查询某次考试某道试题所有人答题情况

    @Query(nativeQuery = true , value ="SELECT DISTINCT a.* FROM answer a INNER  JOIN examination_content c ON c.examination_id = ? AND a.answer_student_id = ?")
    List<Answer> findAnswersByExamination_idAndStudent_id(Integer id1,Integer id2);//查询某个人某场考试回答

    @Query(nativeQuery = true , value = "SELECT  COUNT(DISTINCT a.id) " +
            "FROM answer a INNER  JOIN examination_content c ON c.examination_id = ? AND a.answer_student_id = ? " +
            "AND a.num >0")
    Integer  COUNTAnswersByExamination_idAndStudent_id(Integer id1,Integer id2);//计算某个人某场考试回答正确个数
}
