package guc.supermarket.tests;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import static org.junit.Assert.*;

public class Lab1AllTests {

	String gPath = "guc.supermarket.products.GroceryProduct";
	String bPath = "guc.supermarket.products.Beverage";
	String dPath = "guc.supermarket.products.DairyProduct";

	@Test(timeout = 100)
	public void testClassIsSubclassBeverage() throws Exception {
		testClassIsSubClass(Class.forName(bPath), Class.forName(gPath));
	}

	@Test(timeout = 100)
	public void testClassIsSubclassDairyProduct() throws Exception {
		testClassIsSubClass(Class.forName(dPath), Class.forName(gPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableBeverageSugarLevel() throws Exception {

		testInstanceVariablesArePresent(Class.forName(bPath), "sugarLevel",
				true);
	

	}

	



	@Test(timeout = 100)
	public void testInstanceVariablesGroceryProduct() throws Exception {
		testInstanceVariablesArePresent(Class.forName(gPath), "name", true);
		
		testInstanceVariablesArePresent(Class.forName(gPath), "price", true);
		
		testInstanceVariablesArePresent(Class.forName(gPath), "discount", true);
		
	}


	public void testMethodBeverageGetActualPrice() throws Exception {

		Method[] methodsBeverage = Class.forName(bPath).getDeclaredMethods();
		assertFalse(
				"The method \"getActualPrice\" should be not declared in the Beverage class",
				containsMethodName(methodsBeverage, "getActualPrice"));

	}

	@Test(timeout = 1000)
	public void testMethodBeverageToString() throws Exception {

		Method[] methodsBeverage = Class.forName(bPath).getDeclaredMethods();

		assertTrue(
				"The method \"toString\" should be overriden in the Beverage class",
				containsMethodName(methodsBeverage, "toString"));
	}

	// toString -> Beverage
	// Private
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 1000)
	public void testMethodBeverageToStringLogic() throws Exception {

		int rndmName = (int) (Math.random() * 40) + 10;
		int rndmPrice = (int) (Math.random() * 90) + 10;
		int rndmDisc = (int) (Math.random() * 40) + 10;

		Constructor<?> constructor = Class.forName(bPath).getConstructor(
				String.class, double.class, double.class,
				Class.forName("guc.supermarket.products.SugarLevel"));

		Object createdObject = constructor.newInstance("Schweppes Pomegranate_"
				+ rndmName, rndmPrice, rndmDisc, Enum.valueOf(
				(Class<Enum>) Class
						.forName("guc.supermarket.products.SugarLevel"),
				"ADDED_SUGAR"));

		Method m = createdObject.getClass().getMethod("toString");

		String s = (String) m.invoke(createdObject);

		String t = s.toLowerCase();
		String[] sa = t.split("\n");

		assertEquals(
				"The \"Beverage\" toString() method should return all infromation about the product in 4 lines.\nHint: you can use \"\\n\" in order to insert a line break in a String.",
				4, sa.length);

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Name\" information is missing or incorrect.\n"
						+ s,
				sa[0].contains("name")
						&& sa[0].contains("schweppes pomegranate_" + rndmName));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Price\" information is missing or incorrect.\n"
						+ s,
				sa[1].contains("price") && sa[1].contains("" + rndmPrice));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Discount\" information is missing or incorrect.\n"
						+ s,
				sa[2].contains("discount") && sa[2].contains("" + rndmDisc));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Sugar Level\" information is missing or incorrect.\n"
						+ s, sa[3].contains("sugar") && sa[3].contains("level")
						&& sa[3].contains("added_sugar"));

		rndmName = (int) (Math.random() * 40) + 10;
		rndmPrice = (int) (Math.random() * 90) + 10;
		rndmDisc = (int) (Math.random() * 40) + 10;

		createdObject = constructor.newInstance("Coke Zero_" + rndmName,
				rndmPrice, rndmDisc, Enum.valueOf((Class<Enum>) Class
						.forName("guc.supermarket.products.SugarLevel"),
						"NO_ADDED_SUGAR"));

		s = (String) m.invoke(createdObject);
		t = s.toLowerCase();
		sa = t.split("\n");

		assertEquals(
				"The \"Beverage\" toString() method should return all infromation about the product in 4 lines\nHint: you can use \"\\n\" in order to insert a line break in a String.",
				4, sa.length);

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Name\" information is missing or incorrect.\n"
						+ s,
				sa[0].contains("name")
						&& sa[0].contains("coke zero_" + rndmName));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Price\" information is missing or incorrect.\n"
						+ s,
				sa[1].contains("price") && sa[1].contains("" + rndmPrice));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Discount\" information is missing or incorrect.\n"
						+ s,
				sa[2].contains("discount") && sa[2].contains("" + rndmDisc));

		assertTrue(
				"The \"Beverage\" toString() method should return all infromation about the product; the \"Sugar Level\" information is missing or incorrect.\n"
						+ s, sa[3].contains("sugar") && sa[3].contains("level")
						&& sa[3].contains("no_added_sugar"));

	}

	@Test(timeout = 1000)
	public void testMethodDairyProductgetActualPrice() throws Exception {

		Method[] methodsDairyProduct = Class.forName(dPath)
				.getDeclaredMethods();
		assertFalse(
				"The method \"getActualPrice\" should be not declared in the DairyProduct class",
				containsMethodName(methodsDairyProduct, "getActualPrice"));

	}

	public void testMethodDairyProductToString() throws Exception {

		Method[] methodsDairyProduct = Class.forName(dPath)
				.getDeclaredMethods();

		assertTrue(
				"The method \"toString\" should be overriden in the DairyProduct class",
				containsMethodName(methodsDairyProduct, "toString"));

	}

	// toString -> Dairy
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(timeout = 1000)
	public void testMethodDairyProductToStringLogic() throws Exception {

		int rndmName = (int) (Math.random() * 40) + 10;
		int rndmPrice = (int) (Math.random() * 90) + 10;
		int rndmDisc = (int) (Math.random() * 40) + 10;

		Constructor<?> constructor = Class.forName(dPath).getConstructor(
				String.class, double.class, double.class,
				Class.forName("guc.supermarket.products.Fat"));

		Object createdObject = constructor.newInstance("Juhayna Milk_"
				+ rndmName, rndmPrice, rndmDisc, Enum.valueOf(
				(Class<Enum>) Class.forName("guc.supermarket.products.Fat"),
				"FULLCREAM"));

		Method m = createdObject.getClass().getMethod("toString");

		String s = (String) m.invoke(createdObject);
		String t = s.toLowerCase();
		String[] sa = t.split("\n");

		assertEquals(
				"The \"DairyProduct\" toString() method should return all infromation about the product in 4 lines.\nHint: you can use \"\\n\" in order to insert a line break in a String.",
				4, sa.length);

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Name\" information is missing or incorrect.\n"
						+ s,
				sa[0].contains("name")
						&& sa[0].contains("juhayna milk_" + rndmName));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Price\" information is missing or incorrect.\n"
						+ s,
				sa[1].contains("price") && sa[1].contains("" + rndmPrice));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Discount\" information is missing or incorrect.\n"
						+ s,
				sa[2].contains("discount") && sa[2].contains("" + rndmDisc));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Fat Level\" information is missing or incorrect.\n"
						+ s, sa[3].contains("fat") && sa[3].contains("level")
						&& sa[3].contains("fullcream"));

		rndmName = (int) (Math.random() * 40) + 10;
		rndmPrice = (int) (Math.random() * 90) + 10;
		rndmDisc = (int) (Math.random() * 40) + 10;

		createdObject = constructor.newInstance("Panda Cheese_" + rndmName,
				rndmPrice, rndmDisc, Enum.valueOf((Class<Enum>) Class
						.forName("guc.supermarket.products.Fat"), "SKIMMED"));

		s = (String) m.invoke(createdObject);

		t = s.toLowerCase();
		sa = t.split("\n");

		assertEquals(
				"The \"DairyProduct\" toString() method should return all infromation about the product in 4 lines.\nHint: you can use \"\\n\" in order to insert a line break in a String.",
				4, sa.length);

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Name\" information is missing or incorrect.\n"
						+ s,
				sa[0].contains("name")
						&& sa[0].contains("panda cheese_" + rndmName));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Price\" information is missing or incorrect.\n"
						+ s,
				sa[1].contains("price") && sa[1].contains("" + rndmPrice));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Discount\" information is missing or incorrect.\n"
						+ s,
				sa[2].contains("discount") && sa[2].contains("" + rndmDisc));

		assertTrue(
				"The \"DairyProduct\" toString() method should return all infromation about the product; the \"Fat Level\" information is missing or incorrect.\n"
						+ s, sa[3].contains("fat") && sa[3].contains("level")
						&& sa[3].contains("skimmed"));

	}

	// Private
	@Test(timeout = 1000)
	public void testMethodGroceryProductGetActualPrice() throws Exception {
		Method[] methods = Class.forName(gPath).getDeclaredMethods();
		assertTrue(
				"The method \"getActualPrice\" should be declared in the GroceryProduct class",
				containsMethodName(methods, "getActualPrice"));

	}

	// Private
	@Test(timeout = 1000)
	public void testMethodGroceryProductGetActualPriceAccess() throws Exception {
		assertTrue(
				"You have to make sure that the method \"getActualPrice\" will not to be overridden by any subclass.",
				Modifier.isFinal(Class.forName(gPath)
						.getDeclaredMethod("getActualPrice").getModifiers()));
	}

	// test getActualPrice
	@Test(timeout = 1000)
	public void testMethodGroceryProductGetActualPriceLogic() throws Exception {

		Constructor<?> constructor = Class.forName(gPath).getConstructor(
				String.class, double.class, double.class);

		Object createdObject = constructor.newInstance("Juhayna Milk", 10, 5);

		Method m = createdObject.getClass().getMethod("getActualPrice");

		assertEquals("The actual price should be 9.5", 9.5,
				((double) m.invoke(createdObject)), 0.1);
	}

	@Test(timeout = 1000)
	public void testMethodGroceryProductToString() throws Exception {
		Method[] methods = Class.forName(gPath).getDeclaredMethods();
		assertTrue(
				"The method \"toString\" should be declared in the GroceryProduct class",
				containsMethodName(methods, "toString"));
	}

	// toString -> Grocery
	@Test(timeout = 1000)
	public void testMethodGroceryProductToStringLogic() throws Exception {

		int rndmName = (int) (Math.random() * 40) + 10;
		int rndmPrice = (int) (Math.random() * 90) + 10;
		int rndmDisc = (int) (Math.random() * 40) + 10;

		Constructor<?> constructor = Class.forName(gPath).getConstructor(
				String.class, double.class, double.class);

		Object createdObject = constructor.newInstance("Milk_" + rndmName,
				rndmPrice, rndmDisc);

		Method m = createdObject.getClass().getMethod("toString");

		String s = (String) m.invoke(createdObject);
		String t = s.toLowerCase();
		String[] sa = t.split("\n");

		assertEquals(
				"The \"GroceryProduct\" toString() method should return all infromation about the product in 3 lines.\nHint: you can use \"\\n\" in order to insert a line break in a String.",
				3, sa.length);

		assertTrue(
				"The \"GroceryProduct\" toString() method should return all infromation about the product; the \"Name\" information is missing or incorrect.\n"
						+ s,
				sa[0].contains("name") && sa[0].contains("milk_" + rndmName));

		assertTrue(
				"The \"GroceryProduct\" toString() method should return all infromation about the product; the \"Price\" information is missing or incorrect.\n"
						+ s,
				sa[1].contains("price") && sa[1].contains("" + rndmPrice));

		assertTrue(
				"The \"GroceryProduct\" toString() method should return all infromation about the product; the \"Discount\" information is missing or incorrect.\n"
						+ s,
				sa[2].contains("discount") && sa[2].contains("" + rndmDisc));

	}

	// --------------------------------------------Helper
	// methods----------------------------------------------------------
	public static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	private void testClassIsSubClass(Class subClass, Class superClass) {
		assertEquals(subClass.getName() + " class should inherit from "
				+ superClass.getName() + ".", superClass,
				subClass.getSuperclass());
	}

	@SuppressWarnings("rawtypes")
	private void testInstanceVariablesArePresent(Class aClass, String varName,
			boolean implementedVar) throws SecurityException {

		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse("There should be " + varName
					+ " instance variable in class " + aClass.getName(), thrown);
		} else {
			assertTrue("There should not be " + varName
					+ " instance variable in class " + aClass.getName()
					+ ", it should be inherited from the super class", thrown);
		}
	}

	

	// changed
	

}
