package textExcel;

public class PercentCell extends RealCell{

    public PercentCell(String value) {
        super(value);
    }
    public double getDoubleValue(){
        String improper=useInput();
        improper = improper.substring(0,improper.length()-1);
        double decimal=Double.parseDouble(improper);
        decimal=decimal/100;//makes the number a decimal
        return decimal;
    }
    public String fullCellText(){
        return ""+getDoubleValue();
    }
    public String abbreviatedCellText() {
        String value=useInput();
        if(value.indexOf('.')!=-1){//checks to see if there is a decimal point
            value = value.substring(0,value.indexOf('.'))+"%";
        }
        value+="                          ";
        return value.substring(0,10);
    }

}