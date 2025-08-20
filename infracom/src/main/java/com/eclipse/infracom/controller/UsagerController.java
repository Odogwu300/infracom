package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.UsagerDto;
import com.eclipse.infracom.service.UsagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usagers")
@RequiredArgsConstructor
public class UsagerController {

    private final UsagerService usagerService;

    @GetMapping
    public List<UsagerDto> getAll() {
        return usagerService.findAll();
    }

    @PostMapping
    public UsagerDto create(@RequestBody UsagerDto dto) {
        return usagerService.save(dto);
    }

    @PutMapping("/{id}")
    public UsagerDto update(@PathVariable Long id, @RequestBody UsagerDto dto) {
        return usagerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usagerService.delete(id);
    }
}
