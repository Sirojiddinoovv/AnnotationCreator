package uz.nodir.beanregisterdemo.service.business.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.nodir.beanregisterdemo.model.dto.card.request.CardBalanceRequestDTO;
import uz.nodir.beanregisterdemo.service.business.CardService;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Service
@Slf4j
public class CardServiceImpl implements CardService {

    @Override
    public Long add(CardBalanceRequestDTO requestDTO) {
        log.info("Received command to add balance card with request: {}", requestDTO);

        var balance = 100L;
        // to do some logic
        balance = balance + requestDTO.getAmount();

        log.info("Finished command to add balance card");

        return balance;
    }
}
