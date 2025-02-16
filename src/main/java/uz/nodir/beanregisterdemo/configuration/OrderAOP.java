package uz.nodir.beanregisterdemo.configuration;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import uz.nodir.beanregisterdemo.model.dto.order.request.OrderCreateRequestDTO;
import uz.nodir.beanregisterdemo.model.enums.WeekDay;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Aspect
@Component
@Slf4j
public class OrderAOP {

    @Pointcut(value = "@annotation(uz.nodir.beanregisterdemo.model.annotation.OrderCheck) && args(requestDTO, ..)")
    public void handleOrderRequest(OrderCreateRequestDTO requestDTO) {

    }

    @Around(value = "handleOrderRequest(requestDTO)", argNames = "pjp, requestDTO")
    public Object handleOrderRequest(ProceedingJoinPoint pjp, OrderCreateRequestDTO requestDTO) throws Throwable {

        if (requestDTO.getWeekDay().equals(WeekDay.SATURDAY) || requestDTO.getWeekDay().equals(WeekDay.SUNDAY)) {
            throw new IllegalArgumentException("This day of week is not supported");
        }

        return pjp.proceed();
    }
}
