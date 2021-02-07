package ocp.exam.java11.lambda;

import java.util.ArrayList;
import java.util.List;

import ocp.exam.java11.lambda.finterface.CheckTrait;
import ocp.exam.java11.lambda.finterfaceImp.CheckIfHopper;
import ocp.exam.java11.lambda.model.Animal;

public class TraditionalSearchExample {

	public static void main(String[] args) {
		// List of animals
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("frog", true, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabit", true, false));
		animals.add(new Animal("turtle", false, true));
		
		//pass class that does check - traditional 
		//print(animals, new CheckIfHopper());
		
		// lambda way
		print(animals, a -> a.canHop());
		print(animals, a -> a.canSwim());
	}

	private static void print(List<Animal> animals, CheckTrait checker) {
		for(Animal animal : animals) {
			// general check
			if(checker.test(animal)) {
				System.out.print(animal + " ");
			}
		}
		System.out.println();
	}

}
