package com.mission.request.service.request;

import com.mission.request.dto.RequestDto;
import com.mission.request.enums.Status;
import com.mission.request.exception.NotFound.RequestNotFoundException;
import com.mission.request.exception.StatusException;
import com.mission.request.exception.SuccessException;
import com.mission.request.mapper.RequestMapper;
import com.mission.request.model.Request;
import com.mission.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

    private final RequestMapper requestMapper;
    private final RequestRepository requestRepository;

    @Override
    public Request create(RequestDto request) {
        request.setStatus(Status.PENDING);
        return requestRepository.save(requestMapper.requestDotToRequest(request));
    }

    @Override
    public Page<Request> getAllRequest(Pageable pageable) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        log.info("Get Page: {} Page size: {} Sort By: {} ", pageable.getPageNumber(), pageable.getPageSize(), paging);
        return requestRepository.findAll(paging);
    }

    @Override
    public Optional<Request> findById(Long requestId) {
        Optional<Request> request = requestRepository.findById(requestId);
        if (request.isPresent()){
            return requestRepository.findById((requestId));
        }
        throw new  RequestNotFoundException();
    }

    @Override
    public Optional<RequestDto> update(RequestDto request, Long requestId) {
        Optional<Request> requests = findById(requestId);
        if (requests.isPresent()) {
            if (request.getStatus().equals(Status.PENDING)){
                requestRepository.save(requestMapper.requestDotToRequest(request));
                return Optional.of(request);
            }
            throw new StatusException();
        }
        throw new RequestNotFoundException();
    }

    @Override
    public Optional<RequestDto> deleteById(Long requestId) {
        Optional<Request> requests = findById(requestId);
        if (requests.isPresent()) {
            log.info("Success deleted by id {} ", requestId);
            requestRepository.deleteById(requestId);
            throw new SuccessException();
        }
        throw new RequestNotFoundException();
    }
}
