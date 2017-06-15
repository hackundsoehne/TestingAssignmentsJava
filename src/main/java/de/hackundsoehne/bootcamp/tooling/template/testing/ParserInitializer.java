package de.hackundsoehne.bootcamp.tooling.template.testing;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Reads a supplied file and constructs an {@link CompilationUnit}.
 */
public class ParserInitializer {
    private final CompilationUnit compilationUnit;

    /**
     * creates and {@link ParserInitializer}
     * @param file a Path to the File
     * @throws FileNotFoundException if the file is not found
     * @throws ParseException if unable to parse
     */
    public ParserInitializer(String file) throws FileNotFoundException, ParseException {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream(file);

        // parse the file
        compilationUnit = JavaParser.parse(in);
    }

    public CompilationUnit getCompilationUnit() {
        return compilationUnit;
    }
}
