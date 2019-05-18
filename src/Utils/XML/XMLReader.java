package Utils.XML;

import java.io.*;
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
        final File file = new File(fileName);
        final FileReader fileReader = new FileReader(file);
        final BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
//        Stream<String> inStream = Files.lines(Paths.get(fileName));
//        (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//        inStream.forEach();
//            stream.forEach(System.out::println);
        return null;
    }

    public final static XMLParent Read(final String file) throws IOException {
        return new XMLReader(file).read();
    }

}
