package jminusminus;

import java.util.ArrayList;

class JSwitchStatement extends JStatement {
	
	private JExpression parExpression;
	private ArrayList<JSwitchBlockStatement> switchBlockStatementGroup;
	
	public JSwitchStatement (int line, JExpression expression,
			            ArrayList<JSwitchBlockStatement> switchBlockStatementGroup) {
		super(line);
		this.parExpression = expression;
		this.switchBlockStatementGroup = switchBlockStatementGroup;
	}
	
	public JSwitchStatement analyze(Context context) {
		return this;
	}
	
	public void codegen(CLEmitter output) {
		
	}
	
	public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JSwitchStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<TestExpression>\n");
        p.indentRight();
        parExpression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        p.printf("<SwitchBlockStatementGroup>\n");
        for(JSwitchBlockStatement sta : switchBlockStatementGroup) {
        	p.indentRight();
        	sta.writeToStdOut(p);
        	p.indentLeft();
        }
        p.printf("</SwitchBlockStatementGroup>\n");
        p.indentLeft();
        p.printf("</JSwitchStatement>\n");
		
	}
}
