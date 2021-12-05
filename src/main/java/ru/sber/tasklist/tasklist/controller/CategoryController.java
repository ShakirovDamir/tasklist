package ru.sber.tasklist.tasklist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sber.tasklist.tasklist.entity.Category;
import ru.sber.tasklist.tasklist.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/test")
    public List<Category> test(){
        List<Category> list = categoryRepository.findAll();
        System.out.println("list =  " + list);
        return list;
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
