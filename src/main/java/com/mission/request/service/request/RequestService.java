package com.mission.request.service.request;

import com.mission.request.model.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RequestService {
    Request create(Request request);
    Page<Request> findByRequestBy(String requestBy, Pageable pageable);
    Optional<Request> findById(Long id);
    List<Request> update(Request request, Long id);
    Optional<Request> deleteById(Long id);

}
