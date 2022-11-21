package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Exercise;

import java.util.List;

public interface ExerciseDao {
    // 운동 부위 목록 조회
    List<String> selectAllExercisePart();

    // 전체 운동 목록 조회
    List<Exercise> selectAllExercise();

}
