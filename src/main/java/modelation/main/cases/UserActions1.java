//package modelation.main.cases;
//
//import modelation.main.generator.categorie.templates.CategorieTemplate;
//
//public class UserActions1 extends CategorieTemplate {
//	
//	int counter = 1;
//	String attribute;
//	String action;
//	String assertion;
//	
//	@Override
//	public void beforeTest() {
//		System.out.printf("Cenário: ");
//		System.out.printf("T1."+counter);
//		System.out.printf("\n");
//		System.out.printf("Estar na página de inserir user");
//		counter++;
//	}
//	
//	@Override
//	protected void setup() {
//		
//		this
//		
//		.addDefaultAttributes("DEFAULT")
//		
//		.addAction("Não fazer nada", UserActions1.class)
//		.addAction("Logar com LDAP válido", UserActions1.class)
//		.addDefaultAction("Voltar a página anterior", UserActions2.class)
//		
//		.addAssertion(UserActions1.class, "continuar na página")
//		.addAssertion(UserActions2.class, "está na página anterior");
//	}
//
//	@Override
//	public void attributes() {
//		attribute = attributes.performAttributes();
//		System.out.printf(attribute);
//		System.out.printf("\n");
//	}
//	
//	@Override
//	public void actions() {
//		action = actions.performActions();
//		System.out.printf(action);
//		System.out.printf("\n");
//	}
//
//	@Override
//	public void assertions() {
//		assertion = assertions.performAssertion(actions);
//		System.out.printf(assertion);
//		System.out.printf("\n");
//	}
//
//}
