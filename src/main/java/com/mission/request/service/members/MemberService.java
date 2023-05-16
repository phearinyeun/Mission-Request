package com.mission.request.service.members;

import com.mission.request.model.Members;

import java.util.List;

public interface MemberService {
    Members create(Members members);
    List<Members> getAll();
}
