package ru.sber.tasklist.tasklist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sber.tasklist.tasklist.entity.Priority;
import ru.sber.tasklist.tasklist.repository.PriorityRepository;

import java.util.List;

@RestController
@RequestMapping("/priority")
@RequiredArgsConstructor
public class PriorityController {

    private final PriorityRepository priorityRepository;

    @GetMapping("/test")
    public List<Priority> test(){
        List<Priority> list = priorityRepository.findAll();
        System.out.println("list =  " + list);
        return list;
    }

    @PostMapping("/add")
    public Priority add(@RequestBody Priority priority){
        return priorityRepository.save(priority);
    }
}
