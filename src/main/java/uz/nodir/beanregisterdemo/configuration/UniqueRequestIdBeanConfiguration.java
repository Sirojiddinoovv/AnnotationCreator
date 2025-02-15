package uz.nodir.beanregisterdemo.configuration;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.Configuration;
import uz.nodir.beanregisterdemo.model.annotation.UniqueRequestId;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @author: PC
 * @date: 15.02.2025
 * @group: DavrCoders
 **/

@Configuration
@Slf4j
public class UniqueRequestIdBeanConfiguration implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, @NonNull String beanName) {
        log.info("Start Bean [{}] creation and set properties", beanName);
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();

        boolean hasRandomFields = false;
        for (Field field : fields) {

            if (field.isAnnotationPresent(UniqueRequestId.class)) {
                hasRandomFields = true;
                break;
            }
        }

        if (!hasRandomFields) {
            return bean;
        }


        Enhancer enhancer = getEnhancer(clazz);

        log.info("End Bean [{}] creation", beanName);
        return enhancer.create();
    }

    private static Enhancer getEnhancer(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {

            if (method.getName().startsWith("get")) {
                String fieldName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                Field field = clazz.getDeclaredField(fieldName);

                if (field.isAnnotationPresent(UniqueRequestId.class)) {
                    return generateRandomValue(method.getReturnType(), field.getAnnotation(UniqueRequestId.class).maxLength());
                }
            }

            return proxy.invokeSuper(obj, args);
        });
        return enhancer;
    }


    private static Object generateRandomValue(Class<?> clazz, int maxLength) {
        if (clazz == long.class || clazz == Long.class) {
            var value = System.currentTimeMillis();

            String stringTypeOfLongValue = String.valueOf(value);


            if (stringTypeOfLongValue.length() > maxLength) {
                value = Long.parseLong(stringTypeOfLongValue.substring(0, maxLength));
            }

            return value;
        } else if (clazz == String.class) {
            var value = "GENERATED_" + UUID.randomUUID();


            if (value.length() > maxLength) {
                value = value.substring(0, maxLength);
            }

            return value;
        }

        throw new RuntimeException("Unsupported field type: %s".formatted(clazz.toString()));
    }

}
