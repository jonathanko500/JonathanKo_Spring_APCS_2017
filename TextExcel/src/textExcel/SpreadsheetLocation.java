package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellLocation= "";
	
    @Override
    public int getRow(){
        int rowValue = Integer.parseInt(cellLocation.substring(1))-1;
        return rowValue;
    }

    @Override
    public int getCol(){  
        int colValue =  cellLocation.charAt(0)-65;
    	return colValue;
    }
    
    public SpreadsheetLocation(String cellName){
    	cellLocation = cellName;
    }
}
    