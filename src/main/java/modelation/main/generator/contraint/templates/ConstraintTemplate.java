package modelation.main.generator.contraint.templates;

import modelation.main.generator.contraint.ConstraintObject;
import osmo.tester.annotation.TestStep;

public abstract class ConstraintTemplate extends ConstraintObject {
	
	@Override
	public abstract void header();
	
	@TestStep
	public abstract void execConstraint();
}
