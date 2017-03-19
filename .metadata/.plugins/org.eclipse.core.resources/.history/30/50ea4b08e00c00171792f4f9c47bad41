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
		String x="";
		public String inspect{
			
		}
		
		return x;
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
		spreadsheet += "    |";
		char colsStart = 'A';
		for(int i=0;i<12;i++){//makes the columns
			spreadsheet += ((char)(colsStart))+ "        |";
			colsStart +=1;
		}
		spreadsheet += "\n";
		
		for (int i=0;i<20;i++){
			if(i<9){
				spreadsheet += (i+1)+"  |";//single digit row value
			}else {
				spreadsheet += (i+1) + " |";//2 digit row value
			}
			for(int j = 0; j<12 ; j++){
				spreadsheet += sheet[i][j].abbreviatedCellText() + "|";
			}
			spreadsheet += "    ";
		}
		return spreadsheet;
	}

}
