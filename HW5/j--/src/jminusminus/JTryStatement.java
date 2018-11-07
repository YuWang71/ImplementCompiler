package jminusminus;

import java.util.ArrayList;

public class JTryStatement extends JStatement {

    private ArrayList<JCatch> catches;
    private JBlock finish;
    private JBlock attempt;

    public JTryStatement(int line, JBlock attempt, ArrayList<JCatch> catches, JBlock finish) {
        super(line);
        

        this.attempt = attempt;
        this.catches = catches;
        this.finish = finish;
    }

    @Override
    public JAST analyze(Context context) {
        return this;
    }

    @Override
    public void codegen(CLEmitter output) {

    }

    @Override
    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTryCatchFinallyStatement line=\"%d\">\n", line());
        
        p.indentRight();
        
        p.println("<TryBlock>");
        p.indentRight();
        attempt.writeToStdOut(p);
        p.indentLeft();
        p.println("</TryBlock>");

        
        for (JCatch c : catches) {
            c.writeToStdOut(p);
        }

        if (finish != null) {
        	p.println("<FinallyBlock>");
        	p.indentRight();
        	finish.writeToStdOut(p);
        	p.indentLeft();
        	p.println("</FinallyBlock>");        	
        }
        p.indentLeft();
        p.println("</JTryCatchFinallyStatement>");
    }

}
