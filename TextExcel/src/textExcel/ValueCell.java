package textExcel;

public class ValueCell extends RealCell{

	public ValueCell(String value) {
		super(value);
	}
	public double getDoubleValue(){
		String input=useInput();
		double newNumb=Double.parseDouble(input);
        return newNumb;
    }
	public String abbreviatedCellText() {
		String input=useInput();
		if(input.indexOf(".")==-1){
			input+=(".0");
		}
		input+="                      ";
        return input.substring(0, 10);
	}
    public String fullCellText() {
        return getDoubleValue()+"";
    }

}
