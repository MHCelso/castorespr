package com.pkge.app.service.impl;


import com.pkge.app.entity.History;
import com.pkge.app.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> getAllHistory(String filter) {
        if (filter.equals("ENTRADA")) {
            return historyRepository.findByActionType("ENTRADA");
        }

        if (filter.equals("SALIDA")) {
            return historyRepository.findByActionType("SALIDA");
        }

        return historyRepository.findAll();
    }
}
