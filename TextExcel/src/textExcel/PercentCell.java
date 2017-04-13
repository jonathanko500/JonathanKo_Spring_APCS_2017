package textExcel;

public class PercentCell extends RealCell{

    public PercentCell(String value) {
        super(value);
    }
    public double getDouble(){
        String improper=useInput();
        improper = improper.substring(0,improper.length()-1);
        double decimal=Double.parseDouble(improper);
        return decimal/100;//makes the number a decimal
    }
    public String fullCellText(){
        return ""+getDouble();
    }
    public String abbreviatedCellText() {
        String value=useInput();
        if(value.indexOf('.')!=-1){//checks to see if there is a decimal point
            value = value.substring(0,value.indexOf('.'))+"%";
        }
        return value;
    }

}