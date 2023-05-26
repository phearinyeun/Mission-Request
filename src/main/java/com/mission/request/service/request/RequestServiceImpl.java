package com.mission.request.service.request;

import com.mission.request.dto.RequestDto;
import com.mission.request.enums.Status;
import com.mission.request.exception.NotFound.RequestNotFoundException;
import com.mission.request.exception.SuccessException;
import com.mission.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    private final Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Override
    public RequestDto create(RequestDto request) {
//        Status status = Status.PENDING;
        request.setStatus(Status.PENDING);
        logger.info("Success created Request {} ", request);
        return requestRepository.save(request);
    }

    @Override
    public Page<RequestDto> findByRequestBy(String requestBy, Pageable pageable) {
        Pageable paging = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by("requestBy").ascending());
        log.info("Get Page: {} Page size: {} Sort By: {} {} ", pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(), paging);
        return requestRepository.findAll(paging);
    }

    @Override
    public Optional<RequestDto> findById(Long requestId) {
        Optional<RequestDto> requests = requestRepository.findById(requestId);
        if (requests.isPresent()) {
            log.info("Success get by id {}: {}", requestId, requests);
            return requestRepository.findById(requestId);
        }
        logger.info("Not found and id {}", requestId);
        throw new RequestNotFoundException();
    }

    @Override
    public List<RequestDto> update(RequestDto request, Long requestId) {
        Optional<RequestDto> requestOptional = requestRepository.findById(requestId);
        if (requestOptional.isPresent() && requestOptional.get().getStatus().equals(Status.PENDING)) {
            request.setRequestId(requestId);
            requestRepository.save(request);
            return List.of(request);
        }
        throw new RequestNotFoundException();
    }

    @Override
    public Optional<RequestDto> deleteById(Long requestId) {
        Optional<RequestDto> requests = findById(requestId);
        if (requests.isPresent()) {
            logger.info("Success deleted by id {} ", requestId);
            requestRepository.deleteById(requestId);
            throw new SuccessException();
        }
        throw new RequestNotFoundException();
    }
}
