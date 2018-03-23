package ar.org.centro8.curso.java.utils;

import ar.org.centro8.curso.java.interfaces.Archivo;

public class ArchivoBinario implements Archivo{
    
    private String file;
    
    @Override
    public void setText(String texto) {
        System.out.println("Escribiendo archivo binario");
    }

    @Override
    public String getText() {
        return "Contenido del archivo binario";
    }

    @Override
    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String getFile() {
        return file;
    }
    
}
