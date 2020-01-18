/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import minipython.analysis.*;

public final class TPer extends Token
{
    public TPer()
    {
        super.setText("%");
    }

    public TPer(int line, int pos)
    {
        super.setText("%");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TPer(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPer(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TPer text.");
    }
}