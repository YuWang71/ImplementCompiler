package jminusminus;

import java.util.ArrayList;

public class JForStatement extends JStatement {
	
	ArrayList<JStatement> forInit;
	ArrayList<JStatement> forUpdate;
	JExpression expression;
	JStatement statement;
	
	public JForStatement(int line, ArrayList<JStatement> forInit,
						JExpression expression, ArrayList<JStatement> forUpdate,
						JStatement statement){
		super(line);
		this.forInit = forInit;
		this.forUpdate = forUpdate;
		this.expression = expression;
		this.statement = statement;
	}
	
	public JForStatement analyze(Context context) {
		return this;
	}
	
	public void codegen(CLEmitter output) {
		
	}
	
	public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        if (!forInit.isEmpty()) {
        	p.printf("<InitialExpression>\n");
        	//p.indentRight();
        	for (JStatement statement : forInit) {
                p.indentRight();
                statement.writeToStdOut(p);
                p.indentLeft();
        	}
        	//p.indentLeft();
        	p.printf("</InitialExpression>\n");
        }
        if (expression != null) {
        	p.printf("<TestExpression>\n");
        	p.indentRight();
        	expression.writeToStdOut(p);
        	p.indentLeft();
        	p.printf("</TestExpression>\n");
        }
        if (!forUpdate.isEmpty()) {
        	p.printf("<UpdateExpression>\n");
        	//p.indentRight();
        	for (JStatement statement : forUpdate) {
                p.indentRight();
                statement.writeToStdOut(p);
                p.indentLeft();
        	}
        	//p.indentLeft();
        	p.printf("</UpdateExpression>\n");
        }
    	p.printf("<Statement>\n");
    	p.indentRight();
    	statement.writeToStdOut(p);
    	p.indentLeft();
    	p.printf("</Statement>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
	}

}
