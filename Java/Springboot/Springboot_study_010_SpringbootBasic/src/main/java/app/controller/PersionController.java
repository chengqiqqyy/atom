package app.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.config.AppConfig;
import app.entity.person.CatPerson;
import app.entity.person.DogPerson;
import app.entity.person.HorsePerson;
import app.entity.person.Owner;

@RestController
@RequestMapping("/person")
public class PersionController {
	// ConfigurableApplicationContext 匹配所有ApplicationContext并进行依赖注入
//	@Autowired
//	ConfigurableApplicationContext ctx;
	
	private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@GetMapping("/animal")
	public String useAnimal() {
		// n在此新建 ApplicationContext 实例会重新进行IOC注入
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.getBean(Owner.class).service();
		String className = ctx.getBean(Owner.class).getClass().getSimpleName();
//		ctx.close();
		return "【" + className + "】is call the service."; 
	}
	
	@GetMapping("dogperson")
	public String useDog() {
		ctx.getBean(DogPerson.class).service();
		String className = ctx.getBean(DogPerson.class).getClass().getSimpleName();
		return "【" + className + "】is call the service."; 
	}
	
	@GetMapping("catperson")
	public String useCat() {
		ctx.getBean(CatPerson.class).service();
		String className = ctx.getBean(CatPerson.class).getClass().getSimpleName();
		return "【" + className + "】is call the service."; 
	}
	
	@GetMapping("horseperson")
	public String useHorse() {
		ctx.getBean(HorsePerson.class).service();
		String className = ctx.getBean(HorsePerson.class).getClass().getSimpleName();
		return "【" + className + "】is call the service."; 
	}
	
}
