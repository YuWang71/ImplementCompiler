package jminusminus;

class JBreakStatement extends JStatement {
	
	private String identifier;
	
	public JBreakStatement (int line, String identifier) {
		super(line);
		this.identifier = identifier;
	}
	
	public JBreakStatement analyze (Context context) {
		return this;
	}
	
	public void codegen (CLEmitter output) {
		
	}
	
	public void writeToStdOut (PrettyPrinter p) {
        p.printf("<JBreakStatement line=\"%d\">\n", line());
        p.printf("</JBreakStatement>\n");
	}
}
