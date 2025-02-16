package uz.nodir.beanregisterdemo.service.business;


import uz.nodir.beanregisterdemo.model.dto.order.request.OrderCreateRequestDTO;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/
public interface OrderService {
    String create(OrderCreateRequestDTO requestDTO);

    String update(OrderCreateRequestDTO requestDTO, Long id);
}
