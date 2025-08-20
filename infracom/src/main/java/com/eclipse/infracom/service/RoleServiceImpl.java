package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.RoleDto;
import com.eclipse.infracom.model.Role;
import com.eclipse.infracom.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<RoleDto> findAll() {
        return repository.findAll()
                .stream()
                .map(r -> mapper.map(r, RoleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto save(RoleDto dto) {
        Role role = mapper.map(dto, Role.class);
        return mapper.map(repository.save(role), RoleDto.class);
    }
}
