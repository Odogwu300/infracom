package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> getByUsager(Long usagerId);
    void envoyerNotification(Long usagerId, String message);
}
