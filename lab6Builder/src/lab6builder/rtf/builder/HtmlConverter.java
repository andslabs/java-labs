package lab6builder.rtf.builder;

public class HtmlConverter extends TextConverter{
    
    String result;
    
    public HtmlConverter(){
        result = "<DOCTYPE html>\n<html>\n<body>";
    }
    
    @Override
    public String convertText(String lex){
        lex = lex.replaceAll("(\\\\pard)", "");
        lex = lex.replaceAll("(\\\\par)", "<br>");
        lex = this.convertBold(lex);
        lex = this.convertItalic(lex);
        lex = this.convertUnderscore(lex);
        lex = lex.replaceAll("(\\\\[a-z0-9]{2,} ?)+", "");
        lex = lex.replaceAll("([\\{ ?]+[\\\\\\* a-zA-Z0-9;.]+\\}+)", "");
        if (lex.charAt(lex.length()-1) == '}'){
            lex = lex.substring(0, lex.length()-2);
        }
        result += lex;
        result += "</body>\n</html>";
        return result;
    };
 
    @Override
    public String convertBold(String lex){
        lex = lex.replaceAll("(\\\\b )", "<b>");
        lex = lex.replaceAll("(\\\\b0)", "</b>");
        return lex;
    };
    
    @Override
    public String convertItalic(String lex){
        lex = lex.replaceAll("(\\\\i )", "<i>");
        lex = lex.replaceAll("(\\\\i0)", "</i>");
        return lex;
    };
    
    @Override
    public String convertUnderscore(String lex){
        lex = lex.replaceAll("(\\\\ul )", "<ins>");
        lex = lex.replaceAll("(\\\\ulnone)", "</ins>");
        return lex;
    };
}
