// HW3 Conditional Expression
// HW5 modification of analysis and codegen
package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a conditional expression.
 */

class JConditionalExpression extends JExpression {

    /** Test expression. */
    private JExpression condition;

    /** Then expression. */
    private JExpression thenPart;

    /** Else expression. */
    private JExpression elsePart;

    /**
     * Construct an AST node for a conditional expression given its line number, the test
     * condition, the consequent expression, and the alternative expression.
     * 
     * @param line
     *            line in which the if-statement occurs in the source file.
     * @param condition
     *            test boolean expression.
     * @param thenPart
     *            then expression.
     * @param elsePart
     *            else expression.
     */

    public JConditionalExpression(int line, JExpression condition, JExpression thenPart,
            JExpression elsePart) {
        super(line);
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    /**
     * Analyzing the conditional expression means analyzing its components and checking
     * that the test is boolean.
     * 
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JConditionalExpression analyze(Context context) {
        condition = (JExpression) condition.analyze(context);
        condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        thenPart = (JExpression) thenPart.analyze(context);
        elsePart = (JExpression) elsePart.analyze(context);
        if(thenPart.type()!=elsePart.type()){
            type=Type.ANY;
            JAST.compilationUnit.reportSemanticError(line(),
                                                     "then and else must have same types");
        }else{
            type=thenPart.type();
        }
        return this;
    }

    /**
     * Code generation for a conditional expression. <//>We generate code to branch over the
     * consequent if !test; the consequent is followed by an unconditonal branch
     * over (any) alternate.<//>
     * 
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output, String passInOut){
        this.codegen(output);//HW5 break
    }
    
    public void codegen(CLEmitter output) {
        String elseLabel = output.createLabel();
        String endLabel = output.createLabel();
        condition.codegen(output, elseLabel, false);
        thenPart.codegen(output);
        output.addBranchInstruction(GOTO, endLabel); 
        //else part is no longer conditional for conditional expression
        
        output.addLabel(elseLabel);
        elsePart.codegen(output);
        output.addLabel(endLabel);
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JConditionalExpression line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<TestExpression>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.printf("<ThenExpression>\n");
        p.indentRight();
        thenPart.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ThenExpression>\n");
        p.printf("<ElseExpression>\n");
        p.indentRight();
        elsePart.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ElseExpression>\n");
        p.indentLeft();
        p.printf("</JConditionalExpression>\n");
    }

}
