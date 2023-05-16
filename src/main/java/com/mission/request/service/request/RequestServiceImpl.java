package com.mission.request.service.request;

import com.mission.request.model.Request;
import com.mission.request.repository.RequestRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
//            requestRepository.deleteById(request.getId());
            request.setId(request.getId());
            return requestRepository.save(request);
        }
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> findById(Long id) {
        return requestRepository.findById(id);
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
