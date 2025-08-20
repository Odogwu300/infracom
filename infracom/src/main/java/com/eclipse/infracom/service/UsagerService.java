package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.UsagerDto;

import java.util.List;

public interface UsagerService {
    List<UsagerDto> findAll();
    UsagerDto save(UsagerDto dto);
    UsagerDto update(Long id, UsagerDto dto);
    void delete(Long id);
}

