class Stack {

	int[] stack;
	int size, top1, top2, rear1, rear2;  // using extra rear ptr to point towards last element

	Stack(int size) {
		stack = new int[size];
		top1 = rear1 = 0;
		top2 = rear2 = size - 1;
	}

	void push1(int value) {

		int temp = rear1;

		if(temp < rear2 - 1) {
			while(temp >= top1) {			
				stack[temp + 1] = stack[temp];
				temp--;			
			}
			stack[top1] = value;
			rear1++;	
		} else {
			System.out.println("Stack1 full");
		}			
	}

	void pop1() {

		System.out.println(stack[top1] + " popped");
		stack[top1] = 0;
		int temp = top1;

		while(temp <= rear1) {
			stack[temp] = stack[temp + 1];
			temp++;
		}
	}

	void display1() {
		System.out.print("top1 -> ");
		for(int i = top1; i <= rear1; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}

	void push2(int value) {

		int temp = rear2;
		if(temp > rear1 + 1) {		
			while(temp <= top2) {			
				stack[temp - 1] = stack[temp];
				temp++;			
			}
			stack[top2] = value;
			rear2--;	
		} else {
			System.out.println("Stack2 full");
		}			
	}

	void pop2() {

		System.out.println(stack[top2] + " popped");
		stack[top2] = 0;
		int temp = top2;

		while(temp >= rear2) {
			stack[temp] = stack[temp - 1];
			temp--;
		}
	}

	void display2() {
		System.out.print("top2 -> ");
		for(int i = top2; i >= rear2; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}

public class TwoStacks {

	public static void main(String[] args) {

		Stack objStack = new Stack(10);

		objStack.push1(5);
		objStack.push2(10);
		objStack.push2(15);
		objStack.push1(11);
		objStack.push2(7);
		objStack.push2(40);

		System.out.println("Stack 1:");
		objStack.display1();
		System.out.println("Stack 2:");
		objStack.display2();

		objStack.pop1();  
		objStack.pop2();

		System.out.println("After popping:");
		System.out.println("Stack 1:");
		objStack.display1();
		System.out.println("Stack 2:");
		objStack.display2();
	}
}