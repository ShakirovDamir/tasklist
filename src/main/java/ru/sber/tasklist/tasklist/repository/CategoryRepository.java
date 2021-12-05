package ru.sber.tasklist.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sber.tasklist.tasklist.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
