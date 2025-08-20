package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.NotificationDto;
import com.eclipse.infracom.model.Notification;
import com.eclipse.infracom.model.Usager;
import com.eclipse.infracom.Repository.NotificationRepository;
import com.eclipse.infracom.Repository.UsagerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final UsagerRepository usagerRepository;
    private final ModelMapper mapper;

    @Override
    public List<NotificationDto> getByUsager(Long usagerId) {
        return repository.findByUsagerId(usagerId)
                .stream()
                .map(n -> mapper.map(n, NotificationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void envoyerNotification(Long usagerId, String message) {
        Usager usager = usagerRepository.findById(usagerId)
                .orElseThrow(() -> new RuntimeException("Usager non trouvé"));

        Notification notification = Notification.builder()
                .usager(usager)
                .message(message)
                .lue(false)
                .dateEnvoi(LocalDateTime.now())
                .build();

        repository.save(notification);
    }
}
