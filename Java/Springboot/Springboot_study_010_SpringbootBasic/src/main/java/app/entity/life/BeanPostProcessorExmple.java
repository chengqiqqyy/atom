package app.entity.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// n测试 Bean 的后置处理器
@Component
public class BeanPostProcessorExmple implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor 调用 postProcessorBeforeInitialization 方法，参数【" + bean.getClass().getSimpleName() + "】 【" + beanName + "】");
		return bean;
//		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor 调用 postProcessorAfterInitialization 方法，参数【" + bean.getClass().getSimpleName() + "】 【" + beanName + "】");
		return bean;
//		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	

}
