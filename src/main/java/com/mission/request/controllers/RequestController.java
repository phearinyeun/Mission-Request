package com.mission.request.controllers;

import com.mission.request.model.Request;
import com.mission.request.service.request.RequestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/request")
@AllArgsConstructor
public class RequestController {
    private RequestServiceImpl requestService;

    @GetMapping
    public List<Request> getAll() {
        return requestService.findRequest();
    }
    @GetMapping("/{id}")
    public Optional<Request> findById(@PathVariable Long id){
        return requestService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Optional<Request> deleteById(@PathVariable Long id){
        requestService.deleteById(id);
        return Optional.empty();
    }
    @PostMapping
    public Request create(@RequestBody Request request){
        return requestService.create(request);
    }

    @PostMapping("/update/{id}")
    public List<Request> update(Request request, Long id){
        return requestService.update(request, id);
    }

}
