package uz.nodir.beanregisterdemo.endpoint;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.nodir.beanregisterdemo.service.business.impl.UniqueRequestServiceImpl;

import java.util.Map;

/**
 * @author: PC
 * @date: 15.02.2025
 * @group: DavrCoders
 **/

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UniqueRequestServiceImpl uniqueRequestService;

    @GetMapping
    public ResponseEntity<?> request(@RequestParam("message") String message) {
        uniqueRequestService.sendRequestToThirdParty(message);
        return ResponseEntity.ok(
                Map.of(
                        "result", "SUCCESS"
                )
        );
    }
}
