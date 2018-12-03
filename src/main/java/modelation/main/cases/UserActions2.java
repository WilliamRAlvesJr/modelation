//package modelation.main.cases;
//
//import modelation.main.generator.categorie.templates.CategorieTemplate;
//
//public class UserActions2 extends CategorieTemplate {
//
//	int counter = 1;
//	
//	@Override
//	public void beforeTest() {
//		System.out.printf("Cenário: ");
//		System.out.printf("T2."+counter);
//		System.out.printf("\n");
//		System.out.printf("Estar na página de inserir senha");
//		counter++;
//	}
//	
//	@Override
//	protected void setup() {
//		this
//		
//		.addAttributes("LDAP")
//		.addAttributes("ADMINISTRATIVO")
//		.addAttributes("GRUPO")
//		.addDefaultAttributes("COMUM")
//		
//		.addAction("Logar com falha1", UserActions2.class)
//		.addAction("Logar com falha2", UserActions2.class)
//		.addAction("Logar com falha3", UserActions2.class)
//		.addDefaultAction("logar com sucesso", UserActions1.class)
//		
//		.addAssertion(UserActions1.class, "Troca de página")
//		.addAssertion(UserActions2.class, "Volta a mesma página");
//	}
//
//	@Override
//	public void attributes() {
//		System.out.printf(attributes.performAttributes());
//		System.out.printf("\n");
//	}
//
//	@Override
//	public void actions() {
//		System.out.printf(actions.performActions());
//		System.out.printf("\n");
//	}
//	
//	@Override
//	public void assertions() {
//		System.out.printf(assertions.performAssertion(actions));
//		System.out.printf("\n");
//	}
//}
