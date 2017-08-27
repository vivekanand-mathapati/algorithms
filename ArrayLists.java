import java.util.*;

class ArrayLists{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);// add elements sequentialy
		al.add(20);
		al.add(30);
		al.add(3, 40); // add element at perticular index
		
		Iterator e = al.iterator();// creating iterator
		while(e.hasNext()){
			System.out.println(e.next()+" ");
		}
		
		al.set(1, 50); //set value at perticulr index
		al.remove(0);//remove element at 0
		for(Integer x: al){ //foreach iterator
			System.out.println(x+" ");
		}
		
		System.out.println(al.get(0));//get value using index
		ArrayList<Integer> bl = new ArrayList<Integer>();
		bl.addAll(al);
		System.out.println(bl);
		al.removeAll(bl);
		System.out.println(bl.isEmpty());
	}
}
