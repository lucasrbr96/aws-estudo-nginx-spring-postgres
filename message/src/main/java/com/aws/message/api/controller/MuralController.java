package com.aws.message.api.controller;

import com.aws.message.api.dto.MuralDTORequest;
import com.aws.message.api.dto.MuralDTOResponse;
import com.aws.message.model.Mural;
import com.aws.message.service.MuralService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mural")
public class MuralController {

    private final MuralService service;

    public MuralController(MuralService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MuralDTOResponse> save(@RequestBody MuralDTORequest request){
        Mural mural = service.save(request);

        return ResponseEntity.ok(new MuralDTOResponse(mural.getId(), mural.getName(), mural.getMessage()));
    }

    @GetMapping
    public ResponseEntity<List<MuralDTOResponse>> list(){
        List<Mural> list = service.list();
        List<MuralDTOResponse> body = list.stream().map(mural -> new MuralDTOResponse(mural.getId(), mural.getName(), mural.getMessage()))
                .toList();
        return ResponseEntity.ok(body);
    }
}
