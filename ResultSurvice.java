import java.util.*;
import java.io.*;

class Subjects{
	int id;
	String subject_name;
	Subjects(int id, String subject_name){
		this.id = id;
		this.subject_name = subject_name;
	}
}

class Students{
	int id;
	float l_y_p;
	String name, class_name,phone;
	Students(int id,String name,String class_name,String phone,float l_y_p){
		this.id = id;
		this.name = name;
		this.class_name = class_name;
		this.phone = phone;
		this.l_y_p = l_y_p;
	}
}

class Marks{
	int id, student_id, subject_id, marks_obtained, total_marks;
	float percentage;
	Marks(int id,int student_id,int subject_id,int marks_obtained,int total_marks,float percentage){
		this.id = id;
		this.student_id = student_id;
		this.subject_id = subject_id;
		this.marks_obtained = marks_obtained;
		this.total_marks = total_marks;
		this.percentage = percentage;
	}	
}

class Toppers{
	public void findToppers(ArrayList<Students> stud,ArrayList<Marks> mrks){
		ArrayList<String> cname = new ArrayList<String>();
		Set<String> hs_cname = new HashSet<>();		
		ArrayList<Integer> cstud = new ArrayList<Integer>();
		
		for(int i=0;i<stud.size();i++){
			cname.add(stud.get(i).class_name);
		}
		
		hs_cname.addAll(cname);
		cname.clear();
		cname.addAll(hs_cname);
		
		for(int i=0;i<cname.size();i++){			
			for(int j=0;j<stud.size();j++){
				String sCname = stud.get(j).class_name;
				if(sCname.equals(cname.get(i))){
					cstud.add(stud.get(j).id);					
				}
			}
			
			if(cstud.size()>=3){
				System.out.println(cname.get(i)+" ");
				float first = 0;
				int id = 0;
				for(int j=0;j<cstud.size();j++){	
					try{
						int sid = cstud.get(j);			
						if(mrks.get(sid-1).percentage > first){
							first = mrks.get(sid-1).percentage;
							id = cstud.get(j)-1;
						}
					}catch(Exception e){
						System.out.println("Marks not found for student_id: "+cstud.get(j));
					}
				}	
				System.out.print(stud.get(id).name+", ");	
				
				float second = 0;
				int secid = 0;
				for(int j=0;j<cstud.size();j++){	
					try{
						int sid = cstud.get(j);			
						if(mrks.get(sid-1).percentage > second && mrks.get(sid-1).percentage < first){
							second = mrks.get(sid-1).percentage;
							secid = cstud.get(j)-1;
						}
					}catch(Exception e){
						//System.out.println("Marks not found for student_id: "+cstud.get(j));
					}
				}	
				System.out.print(stud.get(secid).name+", ");	
				
				float third = 0;
				int tid = 0;
				for(int j=0;j<cstud.size();j++){	
					try{
						int sid = cstud.get(j);			
						if(mrks.get(sid-1).percentage > third && mrks.get(sid-1).percentage < second){
							third = mrks.get(sid-1).percentage;
							tid = cstud.get(j)-1;
						}
					}catch(Exception e){
						//System.out.println("Marks not found for student_id: "+cstud.get(j));
					}
				}	
				System.out.print(stud.get(tid).name+" \n\n");
			}
			cstud.clear();
		}
	}	
}

class ResultSurvice{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
				
		ArrayList<Subjects> sbj = new ArrayList<Subjects>();
		ArrayList<Students> stud = new ArrayList<Students>();
		ArrayList<Marks> mrks = new ArrayList<Marks>();
		Toppers top = new Toppers();
		int ch;
		do{
			if(stud.size() > 2)
			top.findToppers(stud,mrks);
			
			System.out.println("1. add new student.\n2. add new subjects.\n3. Add marks.\n4. Update the sudent information.\n5. Disply Students\n6. Exit. \n");
			System.out.print("Please select an option: ");
			ch = in.nextInt();
			switch(ch){
				case 1:
					//add students										
					int id = (stud.size())+1;
					System.out.print("Student name: ");
					String name = in.next();
					System.out.print("Student class: ");
					String class_name = in.next();
					System.out.print("Student phone number: ");
					String phone = in.next();
					System.out.print("Student last year percentage: ");
					float l_y_p = in.nextFloat();
					stud.add(new Students(id,name,class_name,phone,l_y_p));
					System.out.println("Student added successfully!\n");
				break;
				case 2:
					//add subjects					
					int s_id = (sbj.size())+1;
					System.out.print("Subject Name: ");
					String subject_name = in.next();
					sbj.add(new Subjects(s_id,subject_name));
					System.out.println("Subject added successfully!\n");
				break;
				case 3:
					//add marks					
					int m_id = (mrks.size())+1;					
					System.out.print("Student Id: ");
					int std_id = in.nextInt();
					System.out.print("Subject Id: ");
					int sub_id = in.nextInt(); 
					System.out.print("Marks Obtained: ");
					int marks_obtained = in.nextInt();
					System.out.print("Total Marks: ");
					int total_marks = in.nextInt();
					float percentage = ((float)marks_obtained/(float)total_marks)*100;
					mrks.add(new Marks(m_id,std_id,sub_id,marks_obtained,total_marks,percentage));	
					System.out.println("Marks added successfully!\n");				
				break;
				case 4:
					System.out.print("Student Id: ");
					int stud_id = in.nextInt();
					int ech;
					do{
						System.out.println("1. Edit Name.\t 2. Edit Class\t 3. Edit Number\t 4.Edit Percentage\t 5.Exit");
						ech = in.nextInt();
						switch(ech){
							case 1:
								System.out.println(stud.get(stud_id-1).name);
								System.out.print("Edit: ");
								String ename = in.next();
								stud.get(stud_id-1).name = ename;
								System.out.println("Student name updated successfully!\n");
							break;								
							case 2:
								System.out.println(stud.get(stud_id-1).class_name);
								System.out.print("Edit: ");
								String cname = in.next();
								stud.get(stud_id-1).class_name = cname;
								System.out.println("class updated successfully!\n");
							break;
							case 3:
								System.out.println(stud.get(stud_id-1).phone);
								System.out.print("Edit: ");
								String ephone_no = in.next();
								stud.get(stud_id-1).phone = ephone_no;
								System.out.println("phone number updated successfully!\n");
							break;
							case 4:
								System.out.println(stud.get(stud_id-1).l_y_p);
								System.out.print("Edit: ");
								float elyp = in.nextFloat();
								stud.get(stud_id-1).l_y_p = elyp;
								System.out.println("percentage number updated successfully!\n");
							break;
							case 5:
							break;
							default:
								System.out.println("Invalid Entry!!");
							break;
						}
					}while(ech!=5);
				break;
				case 5:
					if(stud.size()<1)
						System.out.println("No students found!");
					for(int i=0;i<stud.size();i++){
						System.out.println(stud.get(i).id+"\t"+stud.get(i).name+"\t"+stud.get(i).class_name+"\t"+stud.get(i).l_y_p);
					}
				break;
				default:
					System.out.println("In valid input!");
				break;
			}
		}while(ch!=6);	
	}	
}
