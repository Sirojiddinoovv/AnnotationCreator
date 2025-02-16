package uz.nodir.beanregisterdemo.model.dto.card.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.nodir.beanregisterdemo.model.annotation.Card;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardBalanceRequestDTO {

    /*
      When taken request from servlet, will be checking this field by CardValidator class.
     */

    @Card(message = "card must be consist of 16 digits", example = "5912 8906 1764 0011")
    private String card;

    @NotNull
    @Min(1)
    private Long amount = 0L;
}
