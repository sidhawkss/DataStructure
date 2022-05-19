package queue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class ClassQueue {
	// Método para inserir contanto na ClassQueue.
	// Method to insert contact into the queue.
	public static void insertContact(Queue<String> ClassQueue) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Insert the contact following the format [sid - 619999-8888]: ");
		String contact = scan.nextLine();
		System.out.printf("Insert a contact: %s\n\n", contact);
		ClassQueue.add(contact);
		show(ClassQueue);
	};
	
	// Method executing the FIFO concept, show the next element to be called and remove from ClassQueue.
	public static void nextContact(Queue<String> ClassQueue) {
		System.out.printf("Next contact to be called: %s\n", ClassQueue.element());
		ClassQueue.remove();
		show(ClassQueue);
	};
	
	// Method to stop the program
	public static void exit(Queue<String> ClassQueue) {
		System.out.println("Exiting...");
		ClassQueue.clear();
		System.exit(0);
	};
	
	// Method to show the ClassQueue.
	public static void show(Queue<String> ClassQueue) {
		System.out.println("Order of ClassQueue: ");
		for(String item: ClassQueue) {
			System.out.printf("%s\n", item);
		}
	}
	
	// Main method executing the program
	public static void main(String args[]) {
		Queue<String> ClassQueue = new LinkedList<String>();
		Boolean verify = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("\t*** contatos call center ***");
		
		
		while (verify) {
			System.out.printf("\n[1]InsertContact \n[2]NextContact \n[3]sair\n");
			System.out.printf("Select a option: ");
			String num = scan.nextLine();
				switch(num){
				case "1":
					insertContact(ClassQueue);
					break;
				case "2":
					nextContact(ClassQueue);
					break;
				case "3":
					verify = false;
					scan.close();
					exit(ClassQueue);
					break;
				default:
					System.out.println("\n\tInvalid option!");
				}	
		}
	}
}

	
