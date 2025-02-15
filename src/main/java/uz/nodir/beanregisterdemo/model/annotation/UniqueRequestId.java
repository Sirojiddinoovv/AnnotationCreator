package uz.nodir.beanregisterdemo.model.annotation;


import java.lang.annotation.*;

/**
 * @author: PC
 * @date: 15.02.2025
 * @group: DavrCoders
 **/

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface UniqueRequestId {

    int maxLength() default 0;
}
