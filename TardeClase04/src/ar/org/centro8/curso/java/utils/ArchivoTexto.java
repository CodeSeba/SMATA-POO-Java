package ar.org.centro8.curso.java.utils;

import ar.org.centro8.curso.java.interfaces.Archivo;

public class ArchivoTexto implements Archivo{
    
    private String file;

    public ArchivoTexto() {
    }
    
    @Override
    public void setText(String texto) {
        System.out.println("Escribiendo archivo de texto");
    }

    @Override
    public String getText() {
        return "Contenido de archivo de texto";
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
