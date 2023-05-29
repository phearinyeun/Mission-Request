package com.mission.request.service.request;

import com.mission.request.dto.RequestDto;
import com.mission.request.enums.Status;
import com.mission.request.exception.NotFound.RequestNotFoundException;
import com.mission.request.exception.SuccessException;
import com.mission.request.mapper.RequestMapper;
import com.mission.request.model.Request;
import com.mission.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final RequestMapper requestMapper;
    private final RequestRepository requestRepository;

    @Override
    public Request create(RequestDto request) {
        return requestRepository.save(requestMapper.requestDotToRequest(request));
    }

//    @Override
//    public Page<RequestDto> getAllRequest(Pageable pageable) {
//        Pageable paging = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("requestBy").ascending());
//        log.info("Get Page: {} Page size: {} Sort By: {} {} ", pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(), paging);
//        return requestRepository.findAll(paging);
//    }
//
//    @Override
//    public Optional<RequestDto> findById(Long requestId) {
//        Optional<RequestDto> requestDto = requestRepository.findById(requestId);
//        if (requestDto.isPresent()){
//            return requestDto;
//        }
//        throw new RuntimeException("Not Found the id");
//    }
//
//    @Override
//    public List<RequestDto> update(RequestDto request, Long requestId) {
//        Optional<RequestDto> requestOptional = requestRepository.findById(requestId);
//        if (requestOptional.isPresent() && requestOptional.get().getStatus().equals(Status.PENDING)) {
//            request.setRequestId(requestId);
//            requestRepository.save(request);
//            return List.of(request);
//        }
//        throw new RequestNotFoundException();
//    }
//
//    @Override
//    public Optional<RequestDto> deleteById(Long requestId) {
//       Optional<RequestDto> requestDto = findById(requestId);
//        if (requestDto.isPresent()) {
//            requestRepository.deleteById(requestId);
//            throw new SuccessException();
//        }
//        throw new RequestNotFoundException();
//    }
}
