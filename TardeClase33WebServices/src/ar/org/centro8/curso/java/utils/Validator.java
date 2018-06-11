package ar.org.centro8.curso.java.utils;

public class Validator {
    private String text;

    public Validator(String text) {
        this.text = text;
    }
    
    public boolean length(int length) {
        return text.length() == length;
    }
    
    public boolean length(int min, int max) {
        return (text.length() >= min && text.length() <= max);
    }
    
    public boolean isInteger(){
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isInteger(int min, int max) {
        if ( isInteger() ) {
            return Integer.parseInt(text) >= min && Integer.parseInt(text) <= max;
        }
        else return false;
    }
    
    public boolean isSecure() {
        if (text.contains("<")) return false;
        if (text.contains(">")) return false;
        if (text.contains("*")) return false;
		if (text.contains(";")) return false;
        return true;
    }
}
