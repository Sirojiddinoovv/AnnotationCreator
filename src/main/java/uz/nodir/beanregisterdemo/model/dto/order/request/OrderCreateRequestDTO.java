package uz.nodir.beanregisterdemo.model.dto.order.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nodir.beanregisterdemo.model.enums.WeekDay;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequestDTO {

    @NotBlank
    private String productName;

    @NotNull
    private WeekDay weekDay;
}
