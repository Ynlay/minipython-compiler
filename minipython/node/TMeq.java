/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TMeq extends Token
{
    public TMeq()
    {
        super.setText("-=");
    }

    public TMeq(int line, int pos)
    {
        super.setText("-=");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TMeq(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTMeq(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TMeq text.");
    }
}
