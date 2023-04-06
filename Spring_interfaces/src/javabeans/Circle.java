package javabeans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Required;

@Component
public class Circle implements Shape{
	private Point center;
	@Autowired
	private MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public Point getCenter() {
		return center;
	}
	//@Required
	//@Autowired
	//@Qualifier("circleRelated")
	@Resource  //If we do not specify the name , it would pick up that bean having the same name as the member variable, center of the class , by default
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(),center.getY()}, "Default Point Message", null));		
		System.out.println("Circle : Point is (" +center.getX()+", "+center.getY()+")");
		//System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
	}
	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}
}