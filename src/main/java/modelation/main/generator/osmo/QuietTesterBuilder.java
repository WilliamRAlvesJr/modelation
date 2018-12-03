package modelation.main.generator.osmo;

import modelation.main.generator.categorie.CategorieObject;
import modelation.main.generator.contraint.templates.ConstraintTemplate;
import osmo.tester.OSMOConfiguration;
import osmo.tester.generator.algorithm.BalancingAlgorithm;
import osmo.tester.generator.endcondition.Length;

public class QuietTesterBuilder {
	private static final int DEFAULT = 1;
	private static int constraintCounter;
	private static int categorieCounter;
	private static int testCounter;
	
	public static QuietTester initOSMO(Object object) {
		OSMOConfiguration config = configOSMO(object);
		QuietTester osmo = new QuietTester();
		osmo.setAlgorithm(new BalancingAlgorithm());
		osmo.setConfig(config);
		return osmo;
	}
	
	public static QuietTester initOSMO(Object object, int ammount) {
		OSMOConfiguration config = new OSMOConfiguration();
		config.setTestEndCondition(new Length(ammount));
		config.setSuiteEndCondition(new Length(DEFAULT));
		config.addModelObject(object);
		
		QuietTester osmo = new QuietTester();
		osmo.setAlgorithm(new BalancingAlgorithm());
		osmo.setConfig(config);
		return osmo;
	}

	private static OSMOConfiguration configOSMO(Object object) {
		OSMOConfiguration config = new OSMOConfiguration();
		config.setTestEndCondition(new Length(DEFAULT));
		config.setSuiteEndCondition(new Length(DEFAULT));
		config.addModelObject(object);
		return config;
	}
	
	public static void generateConstraint(ConstraintTemplate constraint, int ammount) {
		QuietTester osmo = initOSMO(constraint, ammount);
		osmo.generate(DEFAULT);
		constraintCounter++;
	}

	public static void generateCategorie(CategorieObject categorie) {
		QuietTester osmo = initOSMO(categorie);
		osmo.generate(DEFAULT);
		categorieCounter++;
	}
	
	public static void generateStep(Object categorie) {
		QuietTester osmo = initOSMO(categorie);
		osmo.generate(DEFAULT);
		testCounter++;
	}
	
	public static void getReport() {
		System.out.printf("\n");
		System.out.printf("\n");
		System.out.printf("Generated " + constraintCounter + " Constrainsts");
		System.out.printf("\n");
		System.out.printf("With Categories executed " + categorieCounter + " times");
		System.out.printf("\n");
		System.out.printf("Having a total of " + testCounter + " Tests");
		System.out.printf("\n");
		System.out.printf("============================================");
		System.out.printf("\n");
	}
}
