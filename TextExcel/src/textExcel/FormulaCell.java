package textExcel;

public class FormulaCell extends RealCell {

	public FormulaCell(String value) {
		super(value);
	}
	public double getDoubleValue(){
		double answer=0;
		String[] thing1=fullCellText().split(" ");
		thing1[1]=thing1[1].toUpperCase();
		if(thing1[1].equals("AVG")||thing1[1].equals("SUM")){	
		for(int i=3; i<thing1.length; i+=2){
			double additional=Double.parseDouble(thing1[i]);//does calculations
				if(thing1[i-1].equals("+")){//adds
					answer+=additional;
				}
				if(thing1[i-1].equals("-")){//subtracts
					answer-=additional;
				}
				if(thing1[i-1].equals("*")){//multiply
					answer*=additional;
				}
				if(thing1[i-1].equals("/")){//divides
					answer/=additional;
				}
			}
		
		return answer;
		}
		return answer;
		
	}
	public String abbreviatedCellText() {
		String cellInput = "" + this.getDoubleValue();
		String result = cellInput;
		if(cellInput.length() > 10) {
			return(cellInput.substring(0, 10));
		}else {
			for(int i = 0;i<10-cellInput.length();i++) {
				result += " ";
			}
			return result;
		}
	}

}



