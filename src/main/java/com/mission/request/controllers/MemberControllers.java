package com.mission.request.controllers;

import com.mission.request.model.Members;
import com.mission.request.service.members.MemberServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/members")
public class MemberControllers {
    private MemberServiceImpl memberService;

    @PostMapping
    public Members create(@RequestBody Members members){
        return memberService.create(members);
    }
    @GetMapping
    public List<Members> getAll(){
        return memberService.getAll();
    }
}
