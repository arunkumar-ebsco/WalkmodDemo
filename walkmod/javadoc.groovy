import org.walkmod.javalang.ast.CompilationUnit
import org.walkmod.javalang.ast.body.ClassOrInterfaceDeclaration
import org.walkmod.javalang.ast.body.JavadocComment
import org.walkmod.javalang.ast.body.TypeDeclaration
import java.util.Date

((CompilationUnit)node).types.each { TypeDeclaration type ->
    if (type instanceof ClassOrInterfaceDeclaration && !type.isInterface()) {
        type.setJavaDoc(new JavadocComment("File created on ${new Date()}"))
    }
}