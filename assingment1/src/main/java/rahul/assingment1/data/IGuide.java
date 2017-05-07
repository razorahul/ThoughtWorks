package rahul.assingment1.data;

import java.util.ArrayList;
import java.util.List;

import rahul.assingment1.validators.IValidate;

public interface IGuide {
	@SuppressWarnings("serial")
	List<Literal> LITERALS = new ArrayList<Literal>() {
		{
			add(new Literal(1000, 'M'));
			add(new Literal(500, 'D'));
			add(new Literal(100, 'C'));
			add(new Literal(50, 'L'));
			add(new Literal(10, 'X'));
			add(new Literal(5, 'V'));
			add(new Literal(1, 'I'));
		}
	};
	
	public static int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static String[] letters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	class Literal implements Comparable<Literal> {
		private int value;
		private char symbol;

		public Literal(int value, char symbol) {
			super();
			this.value = value;
			this.symbol = Character.toUpperCase(symbol);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public char getSymbol() {
			return symbol;
		}

		public void setSymbol(char symbol) {
			this.symbol = Character.toUpperCase(symbol);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + symbol;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Literal other = (Literal) obj;
			if (symbol != other.symbol)
				return false;
			return true;
		}

		public int compareTo(Literal o) {
			if (null != o)
				return Integer.compare(this.getValue(), o.getValue());
			return -1;
		}

		@Override
		public String toString() {
			return "Literal [value=" + value + ", symbol=" + symbol + "]";
		}

	}

	public static int convert(String literal) {
		if (null != literal && !literal.trim().equalsIgnoreCase("")) {
			if (IValidate.validate(literal)) {
				char[] temp = literal.toCharArray();
				List<IGuide.Literal> literals = new ArrayList<>();
				for (char t : temp) {
					for (IGuide.Literal l : IGuide.LITERALS) {
						if (l.getSymbol() == t) {
							literals.add(l);
							continue;
						}
					}
				}

				int sum = 0;
				for (int i = 0; i < literals.size(); i++) {
					if (i < literals.size() - 1) {
						if (literals.get(i).getValue() < literals.get(i + 1).getValue()) {
							sum += (literals.get(i + 1).getValue() - literals.get(i).getValue());
							i++;
						} else
							sum += literals.get(i).getValue();
					} else
						sum += literals.get(i).getValue();
				}
				return sum;
			}
		}
		return 0;
	}


	public static String create(int sum) {
		if (sum > 1) {
			int value=sum;
			String roman = ""; // The roman numeral.
			for (int i = 0; i < numbers.length; i++) {
				while (value >= numbers[i]) {
					roman += letters[i];
					value -= numbers[i];
				}
			}
			return roman;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(create(1934));
	}
}
