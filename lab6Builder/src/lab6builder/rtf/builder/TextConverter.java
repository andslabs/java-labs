package lab6builder.rtf.builder;

public abstract class TextConverter {
    abstract public String convertText(String lex);
    abstract public String convertBold(String lex);
    abstract public String convertItalic(String lex);
    abstract public String convertUnderscore(String lex);
}
