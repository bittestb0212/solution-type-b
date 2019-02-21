package problem02;

public class Main {

	public static void main(String[] args) {
		String[] expressions = { "3 + 4", "12 * 4", "8 / 2", "10 - 2" };

		for (String expression : expressions) {
			String[] tokens = expression.split(" ");

			String arith = tokens[1];
			int num1 = Integer.parseInt(tokens[0]);
			int num2 = Integer.parseInt(tokens[2]);

			Arithmetic cal = getInstance(arith);
			System.out.println(cal.calculate(num1, num2));

		}
	}

	public static Arithmetic getInstance(String arith) {

		Arithmetic cal=null;
		switch (arith) {
		case "+":
			cal = new Add();
			break;
		case "-":
			cal = new Sub();
			break;
		case "*":
			cal = new Mul();
			break;
		case "/":
			cal = new Div();
			break;
		default:
			break;
		}

		return cal;
	}
}