package com.mission.request.controllers;

import com.mission.request.dto.RequestDto;
import com.mission.request.model.Request;
import com.mission.request.service.request.RequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestServiceImpl requestService;

    @GetMapping
    public Page<Request> getAll(Pageable pageable) {
        return requestService.getAllRequest(pageable);
    }
    @GetMapping("/{requestId}")
    public Optional<Request> findById(@PathVariable Long requestId){
        return requestService.findById(requestId);
    }

    @GetMapping("/delete/{requestId}")
    public Optional<RequestDto> deleteById(@PathVariable Long requestId){
        return requestService.deleteById(requestId);
    }
    @PostMapping
    public Request create(@RequestBody RequestDto request){
        return requestService.create(request);
    }

    @PostMapping("/update/{requestId}")
    public Optional<RequestDto> update(@RequestBody RequestDto request, @PathVariable Long requestId){
        return requestService.update(request, requestId);
    }

}
