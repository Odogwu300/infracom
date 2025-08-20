package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.UsagerDto;
import com.eclipse.infracom.model.Usager;
import com.eclipse.infracom.Repository.UsagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsagerServiceImpl implements UsagerService {

    private final UsagerRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<UsagerDto> findAll() {
        return repository.findAll()
                .stream()
                .map(u -> mapper.map(u, UsagerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsagerDto save(UsagerDto dto) {
        Usager u = mapper.map(dto, Usager.class);
        return mapper.map(repository.save(u), UsagerDto.class);
    }

    @Override
    public UsagerDto update(Long id, UsagerDto dto) {
        Usager u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usager non trouvé"));
        u.setNom(dto.getNom());
        u.setPrenom(dto.getPrenom());
        u.setTelephone(dto.getTelephone());
        u.setAdresse(dto.getAdresse());
        u.setEmail(dto.getEmail());
        return mapper.map(repository.save(u), UsagerDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
