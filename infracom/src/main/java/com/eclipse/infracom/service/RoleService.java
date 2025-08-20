package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto save(RoleDto dto);
}
