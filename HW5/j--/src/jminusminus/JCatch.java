
package jminusminus;

public class JCatch extends JAST {

    private JFormalParameter excpetion;
    private JBlock caught;

    public JCatch(int catchLine, JFormalParameter exception, JBlock caught) {
        super(catchLine);
        
        this.excpetion = exception;
        this.caught = caught;
        
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
        p.printf("<CatchBlock>\n");
        p.indentRight();
        excpetion.writeToStdOut(p);
        caught.writeToStdOut(p);
        
        p.indentLeft();
        p.println("</CatchBlock>");
    }

}
