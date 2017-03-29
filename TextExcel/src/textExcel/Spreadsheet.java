package textExcel;
// Update this file with your own code.

public class Spreadsheet implements Grid{

	private Cell[][]sheet=new Cell[20][12];
	
	public Spreadsheet(){
		for (int k =0;k<sheet.length;k++){//rows
			for (int h = 0;h<sheet[k].length;h++){//columns
				sheet[k][h] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command){
		String location = command;
		if (location.equals("")){
			return "";
		}
		if (location.equalsIgnoreCase("clear")){//clears entire spreadsheet
			for(int i=0;i<sheet.length;i++){
				for (int j=0;j<sheet[i].length;j++){
					sheet[i][j] = new EmptyCell();
				}
			}
			return (getGridText());
		}
		if (location.equalsIgnoreCase("clear ")){//clear one cell
			if(location.startsWith("clear ")){
				SpreadsheetLocation loc = new SpreadsheetLocation(location.substring(6));
				sheet[loc.getRow()][loc.getCol()]=new EmptyCell();
				return getGridText();
			}
		}
		if(location.charAt(0)>64&&location.charAt(0)<91){//inspection of cell
			if(location.indexOf('=')==-1){
				SpreadsheetLocation loc = new SpreadsheetLocation(location.substring(0));
				String cellArea = sheet[loc.getRow()][loc.getCol()].fullCellText();
				return cellArea;
			}
			if(location.indexOf('=')!=-1 && location.indexOf('"')!=-1){//prints text in cell
				
				if(location.charAt(2)==' ')
					sheet[Integer.parseInt(location.substring(1,2))-1][location.charAt(0)-65]=new TextCell(location.substring(location.indexOf('"')+1,location.lastIndexOf('"')));
				else
					sheet[Integer.parseInt(location.substring(1,3))-1][location.charAt(0)-65]=new TextCell(location.substring(location.indexOf('"')+1,location.lastIndexOf('"')));
				String textInCell = getGridText();
				return textInCell;
			}
		}else if(location.charAt(0)>97&&location.charAt(0)<122){//cell inspection if letter is lower case
			if(location.indexOf('=')==-1){
				int i=Integer.parseInt(location.substring(1))-1;
				int j=location.charAt(0)-97;
				String cellArea = sheet[i][j].fullCellText();
				return cellArea;
			}
			if(location.indexOf('=')!=-1 && location.indexOf('"')!=-1){//prints text in cell with lower case letter
				if(location.charAt(2)==' ')
					sheet[Integer.parseInt(location.substring(1,2))-1][location.charAt(0)-97]=new TextCell(location.substring(location.indexOf('"')+1,location.lastIndexOf('"')));
				else
					sheet[Integer.parseInt(location.substring(1,3))-1][location.charAt(0)-97]=new TextCell(location.substring(location.indexOf('"')+1,location.lastIndexOf('"')));
				String textInCell = getGridText();
				return textInCell;
			}
		}
		return "";
	}
	
	@Override
	public int getRows(){
		return sheet.length;
	}

	@Override
	public int getCols(){
		return sheet[0].length;
	}

	@Override
	public Cell getCell(Location loc){
		
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String spreadsheet = "";
		spreadsheet += "   |";
		char columnValue = 'A';
		for(int i=0;i<12; i++){//makes the columns
			spreadsheet+=((char)(columnValue)) + "         |";
			columnValue+=1;
		}
		spreadsheet +="\n";
		for (int i = 0; i < 20; i++){//makes row
			if(i<9){
				spreadsheet += (i+1) + "  |";//one digit row
			} else {
				spreadsheet += (i+1) + " |";//two digit row
			}
			for(int j = 0; j<12 ; j++){
				spreadsheet += sheet[i][j].abbreviatedCellText() + "|";
			}
			spreadsheet += "\n";
		}
		return spreadsheet;
	}

}
