package one_to_many_uni1_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import one_to_many_uni1_Dto1.SchoolDAO;
import one_to_many_uni1_Dto1.StudentDto;
import one_to_many_uni1_dto.School;
import one_to_many_uni1_dto.Student;

public class SchoolMAIN {

	public static void main(String[] args) {

		boolean condition = false;
		School school = new School();
		StudentDto studentDto = new StudentDto();
		SchoolDAO schoolDAO = new SchoolDAO();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out
					.println("enter your choice \n 1.insert \n 2.update \n 3.delete \n 4.get by id \n 5.retrive all ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter school name");
				String nameString = scanner.next();
				System.out.println("enter school addreess");
				String addressString = scanner.next();
				System.out.println("enter phone number ");
				Long phoneLong = scanner.nextLong();

				school.setName(nameString);
				school.setAddress(addressString);
				school.setPhone(phoneLong);

				Student student1 = new Student();

				System.out.println("enter student name");
				String snameString1 = scanner.next();
				System.out.println("enter student address");
				String saddressString1 = scanner.next();

				student1.setName(snameString1);
				student1.setAddress(saddressString1);

				Student student2 = new Student();
				System.out.println("enter student name");
				String snameString2 = scanner.next();
				System.out.println("enter student address");
				String saddressString2 = scanner.next();

				student2.setName(snameString2);
				student2.setAddress(saddressString2);

				List<Student> list = new ArrayList<Student>();
				list.add(student1);
				list.add(student2);

				school.setStudents(list);
//			    studentDto.insertStudent(list);
				schoolDAO.saveSchool(school);

			}
			case 2: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("enter school name");
				String nameString = scanner.next();
				school.setName(nameString);
				school.setId(id);
				schoolDAO.updateSchoool(id, school);
				//studentDto.UPdateStudent(id, Student);
			}

				break;
			case 3: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				school.setId(id);
				schoolDAO.removeSchool(id);
			//	studentDto.deleteStudent(id);
			}

				break;
			case 4: {
				System.out.println("Enter id");
				int id = scanner.nextInt();
				school.setId(id);
				schoolDAO.getSchool(id);
			}

				break;
			case 5: {

				schoolDAO.getAllSchool();
			}

				break;

			default:
				break;
			}

		} while (condition);

	}

}
