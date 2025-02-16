package uz.nodir.beanregisterdemo.model.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: PC
 * @date: 16.02.2025
 * @group: DavrCoders
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OrderCheck {
}
