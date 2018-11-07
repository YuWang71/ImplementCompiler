package jminusminus;

import java.util.ArrayList;

class JSwitchBlockStatement extends JAST {
	
	private ArrayList<JExpression> switchLabels;
	private JStatement blockStatement;
	
	public JSwitchBlockStatement(int line, ArrayList<JExpression> switchLabels,
									JStatement blockStatement) {
		super(line);
		this.switchLabels = switchLabels;
		this.blockStatement = blockStatement;
	}
	
	public JAST analyze(Context context) {
		return this;
	}
	
	public void codegen(CLEmitter output) {
		
	}
	
	public void writeToStdOut(PrettyPrinter p) {
        //p.printf("<JSwitchBlockStatement line=\"%d\">\n", line());
        for (JExpression exp : switchLabels) {
        	if (exp != null) {
        		p.printf("<CaseLabel>\n");
        		p.indentRight();
        		exp.writeToStdOut(p);
        		p.indentLeft();
        		p.printf("</CaseLabel>\n");
        	}
        }
        p.printf("<Body>\n");
		p.indentRight();
		blockStatement.writeToStdOut(p);
		p.indentLeft();
        p.printf("</Body>\n");
	}

}
