package rahul.assingment1.validators;

import java.util.ArrayList;
import java.util.List;

import rahul.assingment1.data.IGuide;

public interface IValidate {
	static List<Character> repeatativeLiterals = new ArrayList<Character>() {
		{
			add('M');
			add('C');
			add('X');
			add('I');
		}
	};
	static List<Character> nonLiterals = new ArrayList<Character>() {
		{
			add('D');
			add('L');
			add('V');
		}
	};

	public static boolean validate(String litral) {
		return false;
	}

	public static boolean validateRepetation(String literal) {
		// for non repeating char
		System.out.println("checking non repeating char");
		for (Character c : nonLiterals) {
			System.out.println("checking if char "+c);
			// (.*(a).*){2,}
			String regex = "(.*(" + c.toString() + ").*){2,}";
			if (literal.matches(regex))
				return false;
		}
		// for repeating chars max 3 reps
		System.out.println("checking repeating char");
		for (Character c : repeatativeLiterals) {
			System.out.println("char "+c);
			// (m){4,}
			String regex = "(" + c.toString() + "){4,}";
			if (literal.matches(regex))
				return false;

			// ^([^m]*(m){0,3}([^m](m))*)$ to see if repeatation with one letter in
			// middle
			regex = "([^" + c.toString() + "]*(" + c.toString() + "){0,3}([^" + c.toString() + "](" + c.toString() + "))*)";
			if (!literal.matches(regex))
				return false;
		}
		return false;
	}

	public static boolean vaidateOrdering(String literal) {
		if(literal!=null){
			boolean good = true;
			char[] literalArray = literal.toCharArray();
			int index = 0;
			for(int i =0;i<literalArray.length;i++){
				IGuide.Literal l = new IGuide.Literal(0,literalArray[i]);
				//check if this symbol exist
				if(!IGuide.LITERALS.contains(l))
					return false;
				
				for(int j =0;j<IGuide.LITERALS.size();j++){
					if(IGuide.LITERALS.get(j).equals(l)){
						index = j;
						l=IGuide.LITERALS.get(j);
					}
				}
				
				//looking next element
				if(i<literalArray.length-1){
					if(literalArray[i] != literalArray[i+1]){
						if(i<literalArray.length-2){
							if(literalArray[i] == literalArray[i+2]){
								IGuide.Literal l2 = new IGuide.Literal(0,literalArray[i+1]);
								if(!IGuide.LITERALS.contains(l2))
									return false;
								i = 1+2;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
