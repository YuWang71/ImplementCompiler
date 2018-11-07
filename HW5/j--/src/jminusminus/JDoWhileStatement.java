package jminusminus;

import static jminusminus.CLConstants.*;

class JDoWhileStatement extends JStatement {
	
	private JExpression test;
	private JStatement statements;
	
	public JDoWhileStatement(int line, JStatement statements, JExpression test) {
		super(line);
		this.test = test;
		this.statements = statements;
	}
	
	public JStatement analyze(Context context) {
		test = test.analyze(context);
        test.type().mustMatchExpected(line(), Type.BOOLEAN);
        statements = (JStatement) statements.analyze(context);
        return this;
	}
	
	public void codegen(CLEmitter output) {
		String input_test = output.createLabel();
    	String output_test = output.createLabel();
    	output.addLabel(input_test);
    	test.codegen(output, output_test, false);
    	statements.codegen(output); 
    	output.addBranchInstruction(GOTO, input_test);
    	output.addLabel(output_test);
  	}
	
	public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JDoWhileStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<Body>\n");
        p.indentRight();
        statements.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.printf("<TestExpression>\n");
        p.indentRight();
        test.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.indentLeft();
        p.printf("</JDoWhileStatement>\n");
	}
}
