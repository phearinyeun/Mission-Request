package com.mission.request.controllers;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import com.mission.request.service.request.RequestServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestServiceImpl requestService;

    @GetMapping
    public Page<RequestDto> getAll(String requestUsername, Pageable pageable) {
        return requestService.findByRequestBy(requestUsername, pageable);
    }
    @GetMapping("/{id}")
    public Optional<RequestDto> findById(@PathVariable Long requestId){
        return requestService.findById(requestId);
    }

    @GetMapping("/delete/{requestId}")
    public Optional<RequestDto> deleteById(@PathVariable("requestId") Long requestId){
        return requestService.deleteById(requestId);
    }
    @PostMapping
    public RequestDto create(@RequestBody RequestDto request){
        return requestService.create(request);
    }

    @PostMapping("/update/{id}")
    public List<RequestDto> update(@RequestBody RequestDto request, @PathVariable Long requestId){
        return requestService.update(request, requestId);
    }

}
