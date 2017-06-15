package de.hackundsoehne.bootcamp.tooling.template.testing;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;

import java.util.List;

/**
 */
public class MethodsCounter {
    private final CompilationUnit com;

    public MethodsCounter(CompilationUnit com) {
        this.com = com;
    }

    public int countMethods() {
        List<TypeDeclaration> types = com.getTypes();
        int counter = 0;
        for (TypeDeclaration type : types) {
            for (BodyDeclaration bodyDeclaration : type.getMembers()) {
                if (bodyDeclaration instanceof MethodDeclaration) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
