import jminusminus.CLEmitter;
import static jminusminus.CLConstants.*;
import java.util.ArrayList;

public class GenIsPrime {
    public static void main(String[] args) {
        CLEmitter e = new CLEmitter(true);
        ArrayList<String> accessFlags =  new ArrayList<String>();
         
        //Add IsPrime Class
        accessFlags.add("public");
        e.addClass(accessFlags, "IsPrime", "java/lang/Object", null,true);

        //Add the implicit no-arg constructor isPrime()
        //This part is very similar with other Gen files in the CLEmitter folder
        accessFlags.clear();
        accessFlags.add("public");
        e.addMethod(accessFlags, "<init>", "()V", null, true);
        e.addNoArgInstruction(ALOAD_0);
        e.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        e.addNoArgInstruction(RETURN);    
    
        //Add isPrime() method to IsPrime
        accessFlags.clear();
        accessFlags.add("private");
        accessFlags.add("static");
        e.addMethod(accessFlags, "isPrime", "(I)Z", null, true);//(I)Z is boolean
        e.addNoArgInstruction(ILOAD_0);
        e.addNoArgInstruction(ICONST_2);
        e.addBranchInstruction(IF_ICMPGE,"FALSELABEL1");
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(IRETURN);
        e.addLabel("FALSELABEL1");
        e.addNoArgInstruction(ICONST_2);
        e.addNoArgInstruction(ISTORE_1);
        //ENTER THE "FOR" LOOP
        e.addBranchInstruction(GOTO, "LOOP");
        e.addLabel("LOOP");
        e.addNoArgInstruction(ILOAD_1);
        e.addNoArgInstruction(ILOAD_0);
        e.addNoArgInstruction(ILOAD_1);
        e.addNoArgInstruction(IDIV);
        //if(n%i==0) return false
        e.addBranchInstruction(IF_ICMPGT, "OUTLOOP");
        e.addNoArgInstruction(ILOAD_0);
        e.addNoArgInstruction(ILOAD_1);
        e.addNoArgInstruction(IREM);
        e.addBranchInstruction(IFNE, "FALSELABEL2");
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(IRETURN);
        e.addLabel("FALSELABEL2");
        //keep "for" looping
        e.addNoArgInstruction(ILOAD_1);
        e.addNoArgInstruction(ICONST_1);
        e.addNoArgInstruction(IADD);
        e.addNoArgInstruction(ISTORE_1);
        e.addBranchInstruction(GOTO, "LOOP");
        e.addLabel("OUTLOOP");
        e.addNoArgInstruction(ICONST_1);
        e.addNoArgInstruction(IRETURN);

        //main method of IsPrime
        accessFlags.clear();
        accessFlags.add("public"); 
        accessFlags.add("static");
        e.addMethod(accessFlags,"main", "([Ljava/lang/String;)V", null, true);
        e.addNoArgInstruction(ALOAD_0);
        e.addNoArgInstruction(ICONST_0);
        e.addNoArgInstruction(AALOAD);
        e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer",
                "parseInt", "(Ljava/lang/String;)I");
        e.addNoArgInstruction(ISTORE_1);
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKESTATIC,"IsPrime", "isPrime","(I)Z");
        e.addNoArgInstruction(ISTORE_2);
        e.addNoArgInstruction(ILOAD_2);
        e.addBranchInstruction(IFEQ, "NOTPRIME");
        e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        e.addReferenceInstruction(NEW, "java/lang/StringBuffer");
        e.addNoArgInstruction(DUP);
        e.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/StringBuffer",
                "<init>", "()V");
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "append", "(I)Ljava/lang/StringBuffer;");
        e.addLDCInstruction(" is a prime number");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "toString", "()Ljava/lang/String;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream",
                "println", "(Ljava/lang/String;)V");
        e.addBranchInstruction(GOTO, "END");
        e.addLabel("NOTPRIME");
        e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out",
                "Ljava/io/PrintStream;");
        e.addReferenceInstruction(NEW, "java/lang/StringBuffer");
        e.addNoArgInstruction(DUP);
        e.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/StringBuffer",
                "<init>", "()V");
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "append", "(I)Ljava/lang/StringBuffer;");
        e.addLDCInstruction(" is not a prime number");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "toString", "()Ljava/lang/String;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream",
                "println", "(Ljava/lang/String;)V");
        e.addBranchInstruction(GOTO, "END");
        e.addLabel("END");
        e.addNoArgInstruction(RETURN);
        
        //write .class file 
        e.write();
    }
}
