package javabeans;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle{
	
	/*private Point pointA;
	private Point pointB;
	private Point pointC;
	*/
	private List<Point> points;
	//Feature of Bean Definition Inheritance - Lets say we have a list of points
	/*public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
*/
	public void draw(){
		
		for(Point point : points){
			System.out.println("Point = (" +point.getX()+", "+point.getY()+")");
		}
		/*System.out.println("Point A = (" +getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("Point B = (" +getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("Point C = (" +getPointC().getX()+", "+getPointC().getY()+")");
		*/
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}

	/*@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}*/

	/*@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is : "+beanName);
		
	}*/
}
