package app.entity.person;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import app.entity.definition.Animal;
import app.entity.definition.Person;

@Component
public class LifePerson implements Person,BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private Animal animal;
	
	@Override
	public void service() {
		this.animal.use();
	}
	
	@Override
	@Autowired
	@Qualifier("dog")
	public void setAnimal(Animal animal) {
		System.out.println("延迟注入");
		this.animal = animal;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("【" + this.getClass().getSimpleName() + "】 调用 BeanNameAware 的 setBeanName 方法");
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("【" + this.getClass().getSimpleName() + "】 调用 BeanFactoryAware 的 setBeanFactory 方法");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("【" + this.getClass().getSimpleName() + "】 调用 ApplicationContextAware 的 setApplicationContext 方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【" + this.getClass().getSimpleName() + "】 调用 ApplicationContextAware 的 afterPropertiesSet 方法");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 注解 @PostConstruct 定义的自定义初始化方法");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 注解 @PreDestroy 定义的自定义销毁方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("【" + this.getClass().getSimpleName() + "】 调用 DisposableBean 的 destroy 方法");
	}
}
