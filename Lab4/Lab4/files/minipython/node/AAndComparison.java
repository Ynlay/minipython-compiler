/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AAndComparison extends PComparison
{
    private PComparison _c1_;
    private PComparison _c2_;

    public AAndComparison()
    {
    }

    public AAndComparison(
        PComparison _c1_,
        PComparison _c2_)
    {
        setC1(_c1_);

        setC2(_c2_);

    }
    public Object clone()
    {
        return new AAndComparison(
            (PComparison) cloneNode(_c1_),
            (PComparison) cloneNode(_c2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAndComparison(this);
    }

    public PComparison getC1()
    {
        return _c1_;
    }

    public void setC1(PComparison node)
    {
        if(_c1_ != null)
        {
            _c1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _c1_ = node;
    }

    public PComparison getC2()
    {
        return _c2_;
    }

    public void setC2(PComparison node)
    {
        if(_c2_ != null)
        {
            _c2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _c2_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_c1_)
            + toString(_c2_);
    }

    void removeChild(Node child)
    {
        if(_c1_ == child)
        {
            _c1_ = null;
            return;
        }

        if(_c2_ == child)
        {
            _c2_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_c1_ == oldChild)
        {
            setC1((PComparison) newChild);
            return;
        }

        if(_c2_ == oldChild)
        {
            setC2((PComparison) newChild);
            return;
        }

    }
}
