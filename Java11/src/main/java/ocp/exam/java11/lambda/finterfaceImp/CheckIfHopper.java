package ocp.exam.java11.lambda.finterfaceImp;

import ocp.exam.java11.lambda.finterface.CheckTrait;
import ocp.exam.java11.lambda.model.Animal;

public class CheckIfHopper implements CheckTrait{

	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}

}
