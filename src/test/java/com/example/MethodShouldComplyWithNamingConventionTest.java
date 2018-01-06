package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.walkmod.javalang.ast.CompilationUnit;
import org.walkmod.javalang.ast.body.MethodDeclaration;
import org.walkmod.javalang.test.SemanticTest;

public class MethodShouldComplyWithNamingConventionTest extends SemanticTest {

    @Test
    public void testMethodNameCorrection() throws Exception {
        CompilationUnit cu = compile("public class Test1 { void some_method(){}; }");
        MethodShouldComplyWithNamingConvention visitor = new MethodShouldComplyWithNamingConvention();
        cu.accept(visitor, null);
        MethodDeclaration md = (MethodDeclaration) cu.getTypes().get(0).getMembers().get(0);
        String name = md.getName();
        Assert.assertEquals("someMethod",name);

    }



}