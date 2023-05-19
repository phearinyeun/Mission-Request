package com.mission.request.service.request;

import com.mission.request.model.Request;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request create(Request request);
    List<Request> findRequest();
    Optional<Request> findById(Long id);
    List<Request> update(Request request, Long id);
    Optional<Request> deleteById(Long id);

}
