package oopIntro;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public void setName(String n) {
		this.name=n;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1= new Person("Jok",13);
		p1.setAge(22);
		System.out.println(p1.getAge());
		p1.setName("Lual");
		System.out.println(p1.getName());
		
	}

}
