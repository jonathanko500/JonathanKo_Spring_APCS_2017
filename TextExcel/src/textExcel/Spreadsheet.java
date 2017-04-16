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
		String[] input = location.split(" ") ;
		input[0]=input[0].toUpperCase();
		if(input[0].equals("CLEAR")){//clear location
			if(input.length>1){
				input[1]=input[1].toUpperCase();
				SpreadsheetLocation loc = new SpreadsheetLocation(input[1]);
				sheet[loc.getRow()][loc.getCol()]=new EmptyCell();
				return getGridText();
			}
		}
		if (input[0].equalsIgnoreCase("CLEAR")){//clears entire spreadsheet
			for(int i=0;i<sheet.length;i++){
				for (int j=0;j<sheet[i].length;j++){
					sheet[i][j] = new EmptyCell();
				}
			}
			return (getGridText());
		}
		if(input[0].charAt(0)>64&&input[0].charAt(0)<91){//inspection of cell
			if(location.indexOf('=')==-1){
				SpreadsheetLocation loc = new SpreadsheetLocation(input[0]);
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
		spreadsheet ="   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |"+"\n";//cols assigned letter
		for (int i=0;i<20;i++){//makes rows
			if(i<9)
				spreadsheet = spreadsheet +(i+1)+"  ";//row value is one digit
			else 
				spreadsheet = spreadsheet +(i+1)+" ";//row value is 2 digit
			for (int h=0;h<12;h++){
				spreadsheet=spreadsheet+"|"+ sheet[i][h].abbreviatedCellText();//cols
			}
			spreadsheet+="|\n";
		}
		
		return spreadsheet;
	}
		

}
