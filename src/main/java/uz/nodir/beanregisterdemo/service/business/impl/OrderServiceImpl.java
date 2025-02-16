package uz.nodir.beanregisterdemo.service.business.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.nodir.beanregisterdemo.model.annotation.OrderCheck;
import uz.nodir.beanregisterdemo.model.dto.order.request.OrderCreateRequestDTO;
import uz.nodir.beanregisterdemo.service.business.OrderService;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @OrderCheck
    @Override
    public String create(OrderCreateRequestDTO requestDTO) {
        log.info("Received command to create order with request: {}", requestDTO);

        // to do some logic

        log.info("Finished command to create order");
        return "Order created successfully";
    }

    @OrderCheck
    @Override
    public String update(OrderCreateRequestDTO requestDTO, Long id) {
        log.info("Received command to update order with request: {}", requestDTO);

        // to do some logic

        log.info("Finished command to update order");
        return "Order created successfully";
    }
}
