package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.ExerciseDao;
import com.eggmoney.backend.model.dto.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseDao exerciseDao;

    // 운동 부위 목록 조회
    @Override
    public List<String> selectAllExercisePart() {
        return exerciseDao.selectAllExercisePart();
    }

    // 전체 운동 목록 조회
    @Override
    public List<Exercise> selectAllExercise() {
        return exerciseDao.selectAllExercise();
    }
}
