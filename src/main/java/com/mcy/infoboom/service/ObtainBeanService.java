package com.mcy.infoboom.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author chaoyang.man
 * @version 1.0
 * @date 2020/3/2 8:08 下午
 * <p>
 * Bean获取的工具类
 */
@Component
public class ObtainBeanService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 根据类对象获取Bean
     *
     * @param clazz 类型对象
     * @param <T>   该Bean的类
     * @return 结果Bean
     */
    @Cacheable(cacheNames = "TEST_TT")
    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 获取范型的实现类的Bean
     *
     * @param clazz        接口的clazz
     * @param genericClazz 具体的范型
     * @param <T>          范型的实现类
     * @return 结果Bean
     */
    public <T> T getGenericsType(Class<T> clazz, Class genericClazz) {
        if (Objects.isNull(clazz) || Objects.isNull(genericClazz)) {
            return null;
        }
        String[] beanNames = applicationContext.getBeanNamesForType(ResolvableType.forClassWithGenerics(clazz, genericClazz));
        if (StringUtils.isBlank(beanNames[0])) {
            return null;
        }
        return (T) applicationContext.getBean(beanNames[0]);
    }

    /**
     * 根据接口类对象获取其实现的Bean的list
     *
     * @param type 接口类对象
     * @param <T>  接口
     * @return 实现类对象
     */
    public <T> List<T> getBeansWithInterface(Class<T> type) {
        Map<String, T> beansOfType = applicationContext.getBeansOfType(type);
        if (CollectionUtils.isEmpty(beansOfType)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(beansOfType.values());
    }


    /**
     * 根据注解拿到所有注解了该注解的Bean
     *
     * @param annotationType 注解类型
     * @return 被注解的对象
     */
    public List<Object> getBeansWithAnnotation(Class<? extends Annotation> annotationType) {
        Map<String, Object> beansOfType = applicationContext.getBeansWithAnnotation(annotationType);
        if (CollectionUtils.isEmpty(beansOfType)) {
            return Collections.emptyList();
        }
        List<Object> result = new ArrayList<>();
        beansOfType.forEach((name, bean) -> {
            result.add(bean);
        });
        return result;
    }


}
