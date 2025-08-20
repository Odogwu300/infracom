package com.eclipse.infracom.service;

import com.eclipse.infracom.dto.StatistiqueDto;

public interface StatistiqueService {
    StatistiqueDto getOccupations();
    StatistiqueDto getPaiements();
}
