package Utils.XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public final class XMLReader implements XMLStrings{

    private final String fileName;

    private XMLReader(final String fileName) throws FileNotFoundException {
        if(!new File(fileName).exists()) throw new FileNotFoundException();
        this.fileName = fileName;
    }

    private final XMLParent read() throws IOException {
        Stream<String> inStream = Files.lines(Paths.get(fileName));
        return null;
    }

    public final static XMLParent Read(final String file) throws IOException {
        return new XMLReader(file).read();
    }

}
