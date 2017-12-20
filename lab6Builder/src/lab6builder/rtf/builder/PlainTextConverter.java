package lab6builder.rtf.builder;

public class PlainTextConverter extends TextConverter{
    
    public PlainTextConverter(){
        
    };
    
    @Override
    public String convertText(String lex){
        String result = lex.replaceAll("(\\\\pard)", "");
        result = result.replaceAll("(\\\\par)", "\n");
        result = result.replaceAll("(\\\\[a-z0-9]{2,} ?)+", "");
        result = result.replaceAll("([\\{ ?]+[\\\\\\* a-zA-Z0-9;.]+\\}+)", "");
        //System.out.println("replace other: " + result);
        result = result.replaceAll("(\\\\b |\\\\i )", "");
        result = result.replaceAll("([\\n]+)", "");
        if (result.charAt(result.length()-1) == '}'){
            result = result.substring(0, result.length()-2);
        }
        return result;
    };
    
    @Override
    public String convertBold(String lex){
        return "";
    };
    
    @Override
    public String convertItalic(String lex){
        return "";
    };
    
    @Override
    public String convertUnderscore(String lex){
        return "";
    };
}
