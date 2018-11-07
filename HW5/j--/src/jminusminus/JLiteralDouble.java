package jminusminus;

import static jminusminus.CLConstants.*;
class JLiteralDouble extends JExpression {

    /** String representation of the double. */
    private String text;

    public JLiteralDouble(int line, String text) {
        super(line);
        this.text = text;
    }

    public JExpression analyze(Context context) {
        type = Type.DOUBLE;
        return this;
    }

    public void codegen(CLEmitter output) {
      double i = Double.parseDouble(text);
    	if(i == 0d)
    		output.addNoArgInstruction(DCONST_0);
    	else if(i == 1d)
    		output.addNoArgInstruction(DCONST_1);
    	else
            output.addLDCInstruction(i);
        
      }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JLiteralDouble line=\"%d\" type=\"%s\" " + "value=\"%s\"/>\n",
                line(), ((type == null) ? "" : type.toString()), text);
    }

}
