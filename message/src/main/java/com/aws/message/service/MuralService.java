package com.aws.message.service;

import com.aws.message.api.dto.MuralDTORequest;
import com.aws.message.model.Mural;
import com.aws.message.repository.MuralRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuralService {

    private final MuralRepository repository;

    public MuralService(MuralRepository repository) {
        this.repository = repository;
    }

    public Mural save(final MuralDTORequest request){
        Mural mural = Mural.from(request.name(), request.message());

        return repository.save(mural);
    }

    public List<Mural> list(){
        return repository.findAll();
    }

    public void delete(final int id){
        repository.deleteById(id);
    }
}
