/*
 * Implement N > 0 stacks using a single array to store all stack data. No stack should be full unless the entire array is full.
 * https://www.youtube.com/watch?v=DxW7VAsdX0o&list=PLNmW52ef0uwsjnM06LweaYEZr-wjPKBnj&index=12
 */

package Facebook;

import java.util.Arrays;

class Stacks {
	int[] topStack;
	int[] stackData;
	int[] nextIndex;
	int nextAvailable;

	Stacks(int stack, int capacity) {
		topStack = new int[stack];
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		nextAvailable = 0;

		Arrays.fill(stackData, 0);

		for (int i = 0; i < capacity - 1; i++) {
			nextIndex[i] = i + 1;
		}
		nextIndex[capacity - 1] = -1;

		Arrays.fill(topStack, -1);

	}

	public void push(int stack, int value) {

		if (stack < 0 || stack >= topStack.length) {
			throw new IllegalArgumentException();
		}

		if (nextAvailable < 0) {
			throw new IllegalAccessError();
		}

		int currentIndex = nextAvailable;
		stackData[currentIndex] = value;
		nextAvailable = nextIndex[currentIndex];
		nextIndex[currentIndex] = topStack[stack];
		topStack[stack] = currentIndex;
	}

	public int pop(int stack) {

		if (stack < 0 || stack >= topStack.length || topStack[stack] == -1) {
			throw new IllegalArgumentException();
		}

		int currentIndex = topStack[stack];
		int value = stackData[currentIndex];
		topStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;
		return value;
	}

	public void printStacks() {
		System.out.println(Arrays.toString(topStack));
		System.out.println(Arrays.toString(stackData));
		System.out.println(Arrays.toString(nextIndex));
		System.out.println(nextAvailable);
		System.out.println("------------------------------------");
	}
}

public class NStackProblem {

	public static void main(String args[]) {

		Stacks stacks = new Stacks(2, 3);

		stacks.push(0, 5);
		stacks.printStacks();
		stacks.push(1, 6);
		stacks.printStacks();
		stacks.pop(0);
		stacks.printStacks();
		stacks.push(1, 8);
		stacks.printStacks();
		stacks.pop(1);
		stacks.printStacks();
	}

}
