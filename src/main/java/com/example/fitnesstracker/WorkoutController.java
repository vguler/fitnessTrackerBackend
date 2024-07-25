package com.example.fitnesstracker;

import com.example.fitnesstracker.model.Workout;
import com.example.fitnesstracker.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        Workout savedWorkout = workoutService.saveWorkout(workout);
        return ResponseEntity.ok(savedWorkout);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Long id) {
        Workout workout = workoutService.getWorkoutById(id);
        return ResponseEntity.ok(workout);
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workouts = workoutService.getAllWorkouts();
        return ResponseEntity.ok(workouts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(@PathVariable Long id, @RequestBody Workout updatedWorkout) {
        Workout existingWorkout = workoutService.getWorkoutById(id);

        Workout savedWorkout = workoutService.updateWorkout(existingWorkout);
        return ResponseEntity.ok(savedWorkout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
