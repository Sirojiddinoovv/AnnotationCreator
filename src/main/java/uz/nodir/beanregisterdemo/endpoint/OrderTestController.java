package uz.nodir.beanregisterdemo.endpoint;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.nodir.beanregisterdemo.model.dto.order.request.OrderCreateRequestDTO;
import uz.nodir.beanregisterdemo.service.business.OrderService;

import java.util.Map;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderTestController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid OrderCreateRequestDTO requestDTO) {
        String result = orderService.create(requestDTO);
        return ResponseEntity.ok(
                Map.of(
                        "result", result
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid OrderCreateRequestDTO requestDTO) {
        String result = orderService.update(requestDTO, id);
        return ResponseEntity.ok(
                Map.of(
                        "result", result
                )
        );
    }
}
