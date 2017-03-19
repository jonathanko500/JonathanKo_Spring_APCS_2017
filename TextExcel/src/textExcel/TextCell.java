package textExcel;

public class TextCell implements Cell {
	private String cellInput;
	public TextCell (String input){
		cellInput=input;
	}

	@Override
	public String abbreviatedCellText() {
		String returnInput=cellInput;
		if(cellInput.length()<10){
			while (returnInput.length()<10){
				returnInput+=" ";
			}
			return returnInput;
		} else if (cellInput.length()>10){
			returnInput=returnInput.substring(0,9);
			return returnInput;
		}else{
			return cellInput;
		}
	}

	@Override
	public String fullCellText() {// TODO Auto-generated method stub
		
		return cellInput;
	}

}