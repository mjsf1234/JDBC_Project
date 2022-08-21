
import java.util.Scanner;


import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to student management system");
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Press 1 to add the student");
			System.out.println("Press 2 to delete the Student");
			System.out.println("Press 3 to display the student");
			System.out.println("Press 4 to Exit");
				
			int choice =  scan.nextInt();
			scan.nextLine();
			
			
			if(choice==1) {
				//add student
				System.out.println("Enter the student Name:");
				String name = scan.nextLine();
				
				System.out.println("Enter the student Phone:");
				String phone = scan.nextLine();
				
				System.out.println("Enter the student city:");
				String city = scan.nextLine();
				
				Student std = new Student(name, phone, city);
				
				boolean ans = StudentDao.insertStudentToDb(std);
				
				if(ans) {
					System.out.println("Student added successfully..");
				}
				else {
					System.out.println("something went wrong...");
				}
				System.out.println(std);
 				
			}
			
			else if (choice ==2) {
				System.out.println("Enter the student Id to delete");
				int id = scan.nextInt();
				scan.nextLine();
				boolean ans = StudentDao.deleteStudent(id);
				
				if(ans) {
					System.out.println("Student deleted successfully");
				}
				else {
					System.out.println("something went wrong...");
				}
			}
			
			else if (choice ==3) {
				StudentDao.showAllStudents();
			}
			
			else {
				break;
			}
		}
		
		scan.close();
	}

}
