package com.mission.request.service.request;

import com.mission.request.model.Request;
import com.mission.request.repository.RequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService{
    private RequestRepository requestRepository;

    @Override
    public Request create(Request request) {
        Optional<Request> requestOptional = requestRepository.findById(request.getId());
        if (requestOptional.isPresent()){
            request.setId(request.getId());
            return requestRepository.save(request);
        }
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findRequest(){
        List<Request> requests = new ArrayList<>(requestRepository.findAll());
        return requests;
    }

    @Override
    public Optional<Request> findById(Long id) {
        List<Request> requests = requestRepository.findRequest();
        if(!requests.isEmpty()){
            return requestRepository.findById(id);
        }
        return null;
    }

    @Override
    public List<Request> update(Request request, Long id) {
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isPresent()){
            request.setId(id);
            requestRepository.save(request);
        }
        return null;
    }

    @Override
    public Optional<Request> deleteById(Long id) {
        return requestRepository.findById(id);
    }
}
