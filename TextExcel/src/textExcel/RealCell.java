package textExcel;

public class RealCell implements Cell {

	@Override
	private String command;
	public RealCell(String input){
		command=input;
	}
	public double getDouble(){
		return Double.parseDouble(command);
	}
	public String cut(String input){
		input=input.substring(0,10);
	}
	public String abbreviatedCellText() {
		return cut(getDouble() + "          ");
	}
	@Override
	public String fullCellText() {
		return command;
	}

}
