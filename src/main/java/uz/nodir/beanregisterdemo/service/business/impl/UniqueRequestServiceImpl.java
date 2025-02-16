package uz.nodir.beanregisterdemo.service.business.impl;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.nodir.beanregisterdemo.model.annotation.UniqueRequestId;
import uz.nodir.beanregisterdemo.service.business.UniqueRequestService;
import uz.nodir.beanregisterdemo.service.client.ClientService;

/**
 * @author: PC
 * @date: 15.02.2025
 * @group: DavrCoders
 **/

@Service
@Slf4j
@RequiredArgsConstructor
public class UniqueRequestServiceImpl implements UniqueRequestService {
    /*
     Mock service
     */
    private ClientService clientService;

    /*
     Auto generate getRequestIdString method from Getter.
     By this name will be taken in own bean post processor configuration
     */

    @Getter
    @UniqueRequestId(maxLength = 16)
    private String requestIdString;

    @Getter
    @UniqueRequestId(maxLength = 4)
    private Long requestIdNumber;

    @Override
    public void sendRequestToThirdParty(String message) {
        log.info("Received command to sending request to third party...");

        // case 1
        log.info("Generated requestId from number: {}", getRequestIdNumber());
        clientService.send(getRequestIdNumber(), message);


        // case 2
        log.info("Generated requestId from string: {}", getRequestIdString());
        clientService.send(getRequestIdString(), message);

        log.info("Finished command to sending request to third party.");
    }
}
