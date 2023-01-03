package recursion_Practise;

 class Student {
	private int age,roll;
	String name;
//	Student(int Age,int Roll,String Name){
//		age=Age;
//		roll=Roll;
//		name=Name;
//	}
//	Student(){
//		
//	}
//	Student(int roll){
//		this.roll=roll;
//	}
	public static void main(String []args) {
		Student s1=new Student();
		Student s2=new Student();
//		System.out.print(s1.name+" "+" ");
//		System.out.println(s2.roll);
		System.out.println(s1);
		System.out.println(s2);
		
	}
	public void setRoll(int rn) {
		if(rn<=0) {
			System.out.println("enter valid rollnumber");
		}else {
			roll=rn;
		}
	}
	public int getRoll() {
		return roll;
	}
	
}