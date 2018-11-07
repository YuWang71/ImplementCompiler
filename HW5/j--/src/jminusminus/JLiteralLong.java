package jminusminus;

import static jminusminus.CLConstants.*;
class JLiteralLong extends JExpression {

    /** String representation of the long. */
    private String text;

    public JLiteralLong(int line, String text) {
        super(line);
        this.text = text;
    }

    public JExpression analyze(Context context) {
        type = Type.LONG;
        return this;
    }

    public void codegen(CLEmitter output) {
        String s = this.text.substring(0, this.text.length()-1);
        Long i = Long.parseLong(s);

    	if(i == 0l)
    		output.addNoArgInstruction(LCONST_0);
    	else if(i == 1l)
    		output.addNoArgInstruction(LCONST_1);
    	else
            output.addLDCInstruction(i);
         
    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JLiteralLong line=\"%d\" type=\"%s\" " + "value=\"%s\"/>\n",
                line(), ((type == null) ? "" : type.toString()), text);
    }

}
