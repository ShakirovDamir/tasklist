package ru.sber.tasklist.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.tasklist.tasklist.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
