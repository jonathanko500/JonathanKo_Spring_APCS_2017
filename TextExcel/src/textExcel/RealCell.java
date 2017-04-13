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
    public double ifDouble(){
        return 0;
    }
    
    @Override
    public String abbreviatedCellText() {
        String text = input + "";
        return text.substring(0,10);
    }

    @Override
    public String fullCellText() {
        return input;
    }
}