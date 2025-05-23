package com.pkge.app.controller;


import com.pkge.app.entity.History;
import com.pkge.app.service.impl.HistoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/history/")
@RequiredArgsConstructor
public class APIHistoryController {
    private final HistoryService historyService;

    @PostMapping("all")
    public ResponseEntity<Object> getHistory(HttpServletRequest request) {
        try {
            String filter = request.getParameter("filter").trim();

            List<History> history = historyService.getAllHistory(filter);

            return ResponseEntity.ok(history);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Error al obtener historial: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
