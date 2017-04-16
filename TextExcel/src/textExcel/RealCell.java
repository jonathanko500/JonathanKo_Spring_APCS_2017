package textExcel;

public class RealCell implements Cell {
    private String input;
    public String useInput(){
        return input;
    }
    public void setInput(String sameInput){
        input=sameInput;
    }
    public RealCell(String value){
        input=value;
    }
    public double getDoubleValue(){
        return 0;
    }
    @Override
    public String abbreviatedCellText() {
        String text = input + "                           ";//truncates to 10 values
        return text.substring(0,10);
    }
    @Override
    public String fullCellText() {
        return input;
    }
}
