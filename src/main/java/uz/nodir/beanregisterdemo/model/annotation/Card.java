package uz.nodir.beanregisterdemo.model.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uz.nodir.beanregisterdemo.model.annotation.validator.CardValidator;

import java.lang.annotation.*;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = CardValidator.class)
public @interface Card {

    String message() default "";

    String example() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
