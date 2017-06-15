package de.hackundsoehne.bootcamp.tooling.template.testing;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class MethodInfo {
    private final CompilationUnit com;

    public MethodInfo(CompilationUnit com) {
        this.com = com;
    }

    public List<String> getMethodParamTypes(String methodName) {
        for (TypeDeclaration typeDeclaration : com.getTypes()) {
            for (BodyDeclaration bodyDeclaration : typeDeclaration.getMembers()) {
                if (bodyDeclaration instanceof MethodDeclaration) {
                    MethodDeclaration methodDeclaration = (MethodDeclaration) bodyDeclaration;
                    if (methodDeclaration.getName().equals(methodName)) {
                        List<String> types = new ArrayList<>();
                        for (Parameter parameter : methodDeclaration.getParameters()) {
                            types.add(parameter.getType().toString());
                        }
                        return types;
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}
