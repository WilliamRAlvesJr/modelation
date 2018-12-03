package modelation.main.generator.contraint;

import java.util.ArrayList;
import java.util.List;

import modelation.main.generator.categorie.CategorieObject;
import modelation.main.generator.categorie.templates.BlankCategorie;

import static modelation.main.generator.osmo.QuietTesterBuilder.generateStep;

public class CategoriesFlow {

	static List<Object> objects = new ArrayList<>();

	public static CategorieObject getCategories(List<Class<?>> klasses) {
		for (Class<?> klass : klasses) {
			CategorieObject.setActualKlass(klass.getName());
			System.out.printf("\n--------------------------------------------\n");

			try {
				iterateWithKlasses(klasses);
			} catch (ReflectiveOperationException e) {
				e.printStackTrace();
			}
			System.out.printf("\n--------------------------------------------");
		}
		return new BlankCategorie();
	}

	private static void iterateWithKlasses(List<Class<?>> klasses) throws ReflectiveOperationException {
		for (int i = 0; i < klasses.size(); i++) {

			createObjects(klasses);

			if (generateIfExist(klasses.get(i), i))
				break;
		}
	}

	private static void createObjects(List<Class<?>> klasses) throws ReflectiveOperationException {
		for (Class<?> klass : klasses) {
			if (!existObject(klass))
				objects.add(klass.newInstance());
		}
	}

	private static boolean generateIfExist(Class<?> klass, int index) throws ReflectiveOperationException {
		if(CategorieObject.getActualKlass() == klass.getName()) {
			
			Object actualObject = objects.get(index);

			generateStep(actualObject);

			return true;
		} 
		return false;
	}

	public static boolean existObject(Class<?> klass) {
		boolean exist = false;
		for (Object obj : objects) {
			if (klass.equals(obj.getClass()))
				exist = true; 	
		}
		return exist;
	}
}
