package everytasc.nineleaps.com.hackaton.DataModel;

/**
 * Created by ravikiran on 27/5/16.
 */
public class Option {

    int code;
    String text;
    String helpUrl = "";

    public Option(String allData){
        String[] al = allData.split("-");
        code = Integer.parseInt(al[0]);
        text =al[1];
    }

    public int getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public String getHelpUrl() {
        return helpUrl;
    }
}
