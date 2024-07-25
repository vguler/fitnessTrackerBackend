package com.example.fitnesstracker.service;

import com.example.fitnesstracker.model.Workout;
import com.example.fitnesstracker.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout saveWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find this workout!"));
    }
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Workout updateWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}
