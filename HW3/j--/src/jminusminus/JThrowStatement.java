package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a throw statement
 */

class JThrowStatement extends JStatement {


    /** The expression. */
	JExpression expr;

    public JThrowStatement(int line, JExpression expr) {
        super(line);
        this.expr = expr;
    }


    public JStatement analyze(Context context) {

        return this;
    }


    public void codegen(CLEmitter output) {
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JThrowException line=\"%d\">\n", line());
        p.indentRight();
        expr.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JThrowException>\n");
    }

}
