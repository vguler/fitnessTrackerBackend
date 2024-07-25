package com.example.fitnesstracker.repository;

import com.example.fitnesstracker.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    /*at the moment there is nothing here*/
}
