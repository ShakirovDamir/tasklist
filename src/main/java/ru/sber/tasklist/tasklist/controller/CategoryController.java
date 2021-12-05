package ru.sber.tasklist.tasklist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.tasklist.tasklist.entity.Category;
import ru.sber.tasklist.tasklist.entity.Priority;
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
    public ResponseEntity<Category> add(@RequestBody Category category){
        if(category.getId() != null && category.getId() != 0){
            return new ResponseEntity("redundant param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }
        if(category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category){
        if(category.getId() == null || category.getId() == 0){
            return new ResponseEntity("redundant param: id", HttpStatus.NOT_ACCEPTABLE);
        }
        if(category.getTitle() == null || category.getTitle().trim().length() == 0){
            return new ResponseEntity("missed param: title", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryRepository.save(category));
    }
}
