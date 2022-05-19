package stacks;
import java.util.Stack;
import java.util.Scanner;



public class ClassStack {
	// Method to insert tasks into the ClassStack.
	public static void insert(Stack<String> ClassStack, String task) {
		ClassStack.push(task);
	}

	// Method to get tasks of the ClassStack.
	public static void getTask(Stack<String> ClassStack) {
		System.out.println("\nYour next task is ["+ ClassStack.peek()+ "]\n");
		ClassStack.pop();
	}

	// Method to show the ClassStack == tasks.
	public static void show(Stack<String> ClassStack) {
		System.out.println("\nYour actual list is: ");
		for(String item: ClassStack) {
			System.out.println(item);
		}
	}
	
	// Method to choose a tem from the ClassStack and place the new order.
	public static void choose(Stack<String> ClassStack, String chosen) {
		Stack<String> queueTemp = new Stack<String>();
		int reference = 0 , counter =0;
		for(String item: ClassStack) {
			if(item.equals(chosen)) {
				reference = counter;
				System.out.println("The chosen was: " + item);
				System.out.println("Removing item... ");
				break;
			}
			counter++;	
		}
		//Counter to define a variable to be used posteriorly and also pass items to another ClassStack.
		for(int i=0; i <= reference; i++) {
			String temp;
			temp = ClassStack.pop();
			queueTemp.push(temp);
		}
		// Removing selected item.
		ClassStack.pop();
		for(int i=0; i <= counter; i++) {
			ClassStack.push(queueTemp.pop());
		}
		
		System.out.println("Displaying the actual temporary queue.");
		for(String elements: ClassStack) {
			System.out.println(elements);
		}
		System.out.println("Next task of the ClassStack: "+ClassStack.peek());
	}
	
	// Main method
	public static void main(String args[]) {
		Stack<String> ClassStack = new Stack<String>();
		Scanner scan = new Scanner(System.in);
		int checker = 0;
		
		// Inserting the first task of the ClassStack.
		System.out.println("Start typing the first task of the ClassStack: ");
		String task = scan.next();
		insert(ClassStack, task);
		
		// Conditional loop to continue inserting items on the ClassStack, if user input not, it stops.
		while(true) {
			System.out.println("Do you wish continue inserting itens into the ClassStack?\n[1]YES [2]NO\n");
			checker = scan.nextInt();
			if(checker == 2) { 
				System.out.println("\nReady! Your ClassStack of tasks are complete, let's do it now!");
				break;
			}
			System.out.println("Insert your task into the ClassStack: ");
			task = scan.next();
			insert(ClassStack, task);
		}
		
		// Contidional loop to show the tasks and control. 
		while(ClassStack.size() != 0) {
			System.out.println("Do you want to proceed to the next task? \n[1]YES [2]Show ClassStack [3]Choose Task");
			checker = scan.nextInt();
			if(checker == 1) getTask(ClassStack); ;
			if(checker == 2) show(ClassStack);
			if(checker == 3) {
				System.out.println("Type the task to choose.");
				task = scan.next();
				choose(ClassStack, task);
			}
			if(ClassStack.size() == 0) System.out.println("Congratulations you made all the tasks.");  ;
		}
		scan.close();
	}
}