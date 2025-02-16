package uz.nodir.beanregisterdemo.service.business;


import uz.nodir.beanregisterdemo.model.dto.card.request.CardBalanceRequestDTO;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/
public interface CardService {
    Long add(CardBalanceRequestDTO requestDTO);
}
