package Utils.XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public final class XMLWriter implements XMLStrings{

    private final XMLParent mXML;
    private final File mOutput;
    private int mIndentation = 0;
    private final static int INDENTATION = 4;

    private XMLWriter(final File output, final XMLParent xml) throws IOException {
        if(!output.exists() && !output.createNewFile()) throw new FileNotFoundException();
        mOutput = output;
        mXML = xml;
    }

    public final void write() throws IOException {
        FileWriter w = new FileWriter(mOutput);
        handleSiftXML(w, mXML);
        w.close();
    }

    private final void handleSiftXML(final Writer w, final XMLEntry e) throws IOException {
        writeToFile(w, getIndentation()+e.parseToXML());
        if(e.isParent()){
            final XMLParent p = (XMLParent) e;
            incrementIndentation();
            while(!p.isEmpty()){
                handleSiftXML(w, p.getNextChild());
            }
            decrementIndentation();
            writeToFile(w, getIndentation()+p.getCloseLabel());
        }
    }

    private final void writeToFile(final Writer w, final String s) throws IOException {
        w.write(s+LINE_BREAK);
        System.out.println(s);
    }

    private final void incrementIndentation(){
        mIndentation += INDENTATION;
    }

    private final void decrementIndentation(){
        if(mIndentation >= INDENTATION) mIndentation -= INDENTATION;
    }

    private final String getIndentation(){
        String indentation = "";
        for(int i = 0; i<mIndentation; i++){
            indentation += " ";
        }
        return indentation;
    }

    public final static XMLWriter NewInstance(final String fileOutputLocation, final XMLParent xml) throws IOException {
        return new XMLWriter(new File(fileOutputLocation), xml);
    }

}
