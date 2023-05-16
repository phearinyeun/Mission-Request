package com.mission.request.service.members;

import com.mission.request.model.Members;
import com.mission.request.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{
    private MembersRepository membersRepository;
    @Override
    public Members create(Members members) {
        return membersRepository.save(members);
    }

    @Override
    public List<Members> getAll() {
        return membersRepository.findAll();
    }
}
