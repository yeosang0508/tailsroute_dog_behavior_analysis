package com.project.tailsroute.service;

import com.project.tailsroute.repository.DiaryRepository;

import com.project.tailsroute.vo.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Transactional
    public void writeDiary(int memberId, String title, String body, String imagePath,
                           LocalDate startDate, LocalDate endDate,
                           LocalTime takingTime, String information) {


        diaryRepository.writeDiary(memberId, title, body, imagePath, startDate, endDate, takingTime, information);
    }

    public List<Diary> getDiaryList(String sort) {
        if ("oldest".equals(sort)) {
            return diaryRepository.findAllByOrderByDateAsc(); // 오래된순
        } else {
            return diaryRepository.findAllByOrderByDateDesc(); // 최신순
        }
    }


}