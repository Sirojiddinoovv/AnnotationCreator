package uz.nodir.beanregisterdemo.model.annotation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import uz.nodir.beanregisterdemo.model.annotation.Card;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Slf4j
public class CardValidator implements ConstraintValidator<Card, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Taken object in card field: {}", s);

        if(s == null || s.isEmpty())
            return false;

        return s.matches("\\d{16}");
    }
}
