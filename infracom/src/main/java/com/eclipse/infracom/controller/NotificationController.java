package com.eclipse.infracom.controller;

import com.eclipse.infracom.dto.NotificationDto;
import com.eclipse.infracom.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/usager/{id}")
    public List<NotificationDto> getByUsager(@PathVariable Long id) {
        return notificationService.getByUsager(id);
    }

}

