/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ALesscComparison extends PComparison
{
    private PExpression _lpar_;
    private PExpression _rpar_;

    public ALesscComparison()
    {
    }

    public ALesscComparison(
        PExpression _lpar_,
        PExpression _rpar_)
    {
        setLpar(_lpar_);

        setRpar(_rpar_);

    }
    public Object clone()
    {
        return new ALesscComparison(
            (PExpression) cloneNode(_lpar_),
            (PExpression) cloneNode(_rpar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALesscComparison(this);
    }

    public PExpression getLpar()
    {
        return _lpar_;
    }

    public void setLpar(PExpression node)
    {
        if(_lpar_ != null)
        {
            _lpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lpar_ = node;
    }

    public PExpression getRpar()
    {
        return _rpar_;
    }

    public void setRpar(PExpression node)
    {
        if(_rpar_ != null)
        {
            _rpar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rpar_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lpar_)
            + toString(_rpar_);
    }

    void removeChild(Node child)
    {
        if(_lpar_ == child)
        {
            _lpar_ = null;
            return;
        }

        if(_rpar_ == child)
        {
            _rpar_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lpar_ == oldChild)
        {
            setLpar((PExpression) newChild);
            return;
        }

        if(_rpar_ == oldChild)
        {
            setRpar((PExpression) newChild);
            return;
        }

    }
}