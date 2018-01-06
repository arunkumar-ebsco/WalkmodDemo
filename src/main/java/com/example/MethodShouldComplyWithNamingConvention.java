package com.example;

import org.walkmod.javalang.ast.body.BodyDeclaration;
import org.walkmod.javalang.ast.body.ClassOrInterfaceDeclaration;
import org.walkmod.javalang.ast.body.MethodDeclaration;
import org.walkmod.javalang.compiler.symbols.RequiresSemanticAnalysis;
import org.walkmod.javalang.visitors.VoidVisitorAdapter;
import org.walkmod.walkers.VisitorContext;

import java.util.List;


@RequiresSemanticAnalysis
public class MethodShouldComplyWithNamingConvention extends VoidVisitorAdapter<VisitorContext> {

    private boolean isValidVariableName(String name) {
        if (name == null || name.length() == 0) {
            return false;
        }
        char initial = name.charAt(0);
        if (Character.isLetter(initial) && Character.isLowerCase(initial)) {
            if (name.contains("_") || name.contains("\\$")) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private String getValidNewName(String name) {
        char[] letters = name.toCharArray();
        String result = "";
        boolean toUpperCase = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '$' || letters[i] == '_') {
                i++;
                toUpperCase = true;
            } else {
                if (toUpperCase) {
                    result += Character.toUpperCase(letters[i]);
                    toUpperCase = false;
                } else {
                    result += Character.toLowerCase(letters[i]);
                }
            }
        }
        return result;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, VisitorContext ctx) {
        List<BodyDeclaration> members = n.getMembers();
        for (int i = 0; i < members.size();) {
            BodyDeclaration bodyDeclaration = members.get(i);
            if (bodyDeclaration instanceof MethodDeclaration) {
                MethodDeclaration methodDeclaration = ((MethodDeclaration) bodyDeclaration);
                String name = methodDeclaration.getName();
                if (!isValidVariableName(name)) {
                    methodDeclaration.setName(getValidNewName(name));
                }
            }
        }
        //super.visit(n, ctx);
    }

}
