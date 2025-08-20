package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.RoleDto;
import com.eclipse.infracom.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.findAll();
    }

    @PostMapping
    public RoleDto create(@RequestBody RoleDto dto) {
        return roleService.save(dto);
    }
}
