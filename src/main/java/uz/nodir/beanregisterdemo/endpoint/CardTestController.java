package uz.nodir.beanregisterdemo.endpoint;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nodir.beanregisterdemo.model.dto.card.request.CardBalanceRequestDTO;
import uz.nodir.beanregisterdemo.service.business.CardService;

import java.util.Map;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardTestController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid CardBalanceRequestDTO requestDTO) {
        Long result = cardService.add(requestDTO);
        return ResponseEntity.ok(
                Map.of(
                        "result", result
                )
        );
    }
}
