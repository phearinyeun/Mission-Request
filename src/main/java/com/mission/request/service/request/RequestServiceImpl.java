package com.mission.request.service.request;

import com.mission.request.exception.NotFound.RequestNotFoundException;
import com.mission.request.exception.SuccessException;
import com.mission.request.model.Request;
import com.mission.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;

    private final Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Override
    public Request create(Request request) {
        logger.info("Success created Request {} ", request);
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findRequest(){
        List<Request> requests = requestRepository.findAll();
        logger.info("Success get request {}", requests);
        return requests;
    }

    @Override
    public Optional<Request> findById(Long id) {
        Optional<Request> requests = requestRepository.findById(id);
        if(requests.isPresent()){
            log.info("Success get by id {}: {}", id, requests);
            return requestRepository.findById(id);
        }
        logger.info("Not found and id {}", id);
        throw new RequestNotFoundException();
    }

    @Override
    public List<Request> update(Request request, Long id) {
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isPresent()){
            request.setId(id);
            logger.info("Success updated request by id {} : {}", id, request);
            return List.of(request);
        }
        throw new RequestNotFoundException();
    }

    @Override
    public Optional<Request> deleteById(Long id) {
        Optional<Request> requests = findById(id);
        if(requests.isPresent()){
            logger.info("Success deleted by id {} ", id);
            requestRepository.deleteById(id);
            throw new SuccessException();
        }
        throw new RequestNotFoundException();
    }
}
