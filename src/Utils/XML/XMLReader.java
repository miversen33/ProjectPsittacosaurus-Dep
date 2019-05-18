package Utils.XML;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class XMLReader implements XMLStrings{

    private final static String CLOSED_TAG = "CLOSED";

    private final String fileName;
    private boolean inComment = false;

    private XMLReader(final String fileName) throws FileNotFoundException {
        if(!new File(fileName).exists()) throw new FileNotFoundException();
        this.fileName = fileName;
    }

    private final XMLParent read() throws IOException {
        final File file = new File(fileName);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        final List<XMLParent> openParents = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null){
            XMLEntry entry = handleLine(line);
            boolean handled = false;
            if(entry != null && entry.isParent()){
                openParents.add((XMLParent) entry);
                handled = true;
            }
            if(entry != null && entry.getInfo().equalsIgnoreCase(CLOSED_TAG)){
                if(openParents.size() > 1) {
                    openParents.get(openParents.size() - 2).addChild(openParents.get(openParents.size() - 1));
                    openParents.remove(openParents.size() - 1);
                }
                handled = true;
            }
            if(!handled){
                openParents.get(openParents.size() - 1).addChild(entry);
            }
        }
        reader.close();
        fileReader.close();

        if(openParents.size() > 0){
            return openParents.get(0);
        } else{
            System.out.println("Unable to completely parse XML info");
        }
        return null;
    }

    private final XMLEntry handleLine(String line){
        if(line.startsWith(BEGIN_COMMENT)) inComment = true;
        if(line.endsWith(END_COMMENT)){
            inComment = false;
            return null;
        }

        if(inComment) return null;
        XMLEntry returnEntry;
        boolean isBeginning;
        boolean isEnd;
        line = line.replace(INDENTATION,"");
        isEnd = line.startsWith(CLOSE_BRACKET_WITH_TITLE);
        isBeginning = (!isEnd && line.startsWith(BEGIN_BRACKET) &! line.endsWith(CLOSE_BRACKET) &! line.contains(CLOSE_BRACKET_WITH_TITLE));

        if(isEnd){
            line = line.replace(CLOSE_BRACKET_WITH_TITLE,"").replace(OPEN_END_BRACKET,"");
            return new XMLEntry(line, CLOSED_TAG);
        }

        if(isBeginning){
            returnEntry = createNewParent(line);
        } else {
            returnEntry = createNewChild(line);
        }

        return returnEntry;
    }

    private final XMLParent createNewParent(String input){
        input = input.replace(BEGIN_BRACKET,"").replace(OPEN_END_BRACKET,"");
        return new XMLParent(input);
    }

    private final XMLEntry createNewChild(String input){
        XMLEntry returnEntry = null;
        if(input.startsWith(BEGIN_BRACKET) &! input.startsWith(CLOSE_BRACKET_WITH_TITLE)){
            String start = BEGIN_BRACKET+input.substring(1,input.indexOf(OPEN_END_BRACKET))+OPEN_END_BRACKET;
            String end = start.replace(BEGIN_BRACKET, CLOSE_BRACKET_WITH_TITLE);
            String value = input.replace(start,"").replace(end,"");
            String title = input.replace(end,"").replace(value,"").replace(BEGIN_BRACKET,"").replace(OPEN_END_BRACKET,"");
            return new XMLEntry(title, value);
        }
        input = input.replace(BEGIN_BRACKET,"").replace(OPEN_END_BRACKET,"");
        if(input.contains(EQUALS)){
            String inputTitle = input.split(EQUALS)[0];
            String inputValue = input.split(EQUALS)[1].replace(QUOTATION,"");
            returnEntry = new XMLEntry(inputTitle, inputValue);
        }
        return returnEntry;
    }

    public final static XMLParent Read(final String file) throws IOException {
        return new XMLReader(file).read();
    }

}
