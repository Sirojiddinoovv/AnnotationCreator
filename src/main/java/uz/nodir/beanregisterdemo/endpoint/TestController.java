package uz.nodir.beanregisterdemo.endpoint;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.nodir.beanregisterdemo.service.business.impl.UniqueRequestServiceImpl;

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
    public void test() {
        uniqueRequestService.sendRequestToThirdParty("Test");
    }
}
