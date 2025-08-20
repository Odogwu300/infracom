package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.InfrastructureDto;
import com.eclipse.infracom.service.InfrastructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/infrastructures")
@RequiredArgsConstructor
public class InfrastructureController {

        private final InfrastructureService infrastructureService;

        @GetMapping
        public List<InfrastructureDto> getAll() {
            return infrastructureService.findAll();
        }

        @PostMapping
        public InfrastructureDto create(@RequestBody InfrastructureDto dto) {
            return infrastructureService.save(dto);
        }

        @PutMapping("/{id}")
        public InfrastructureDto update(@PathVariable Long id, @RequestBody InfrastructureDto dto) {
            return infrastructureService.update(id, dto);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            infrastructureService.delete(id);
        }
    }

