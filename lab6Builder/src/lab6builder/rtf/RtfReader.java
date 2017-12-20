package lab6builder.rtf;

import lab6builder.rtf.builder.*;

public class RtfReader {
    
    private String content;
    private TextConverter textConverter;
    
    public RtfReader(String content){
        this.content = content;
    }
    
    public String getText(){
        textConverter = new PlainTextConverter();
        return textConverter.convertText(content);
    }
    
    public String convertToHtml(){
        textConverter = new HtmlConverter();
        return textConverter.convertText(content);
    }
}
