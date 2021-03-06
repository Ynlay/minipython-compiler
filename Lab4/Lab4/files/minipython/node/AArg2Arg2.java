/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AArg2Arg2 extends PArg2
{
    private TId _id_;
    private PArg1 _arg1_;

    public AArg2Arg2()
    {
    }

    public AArg2Arg2(
        TId _id_,
        PArg1 _arg1_)
    {
        setId(_id_);

        setArg1(_arg1_);

    }
    public Object clone()
    {
        return new AArg2Arg2(
            (TId) cloneNode(_id_),
            (PArg1) cloneNode(_arg1_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArg2Arg2(this);
    }

    public TId getId()
    {
        return _id_;
    }

    public void setId(TId node)
    {
        if(_id_ != null)
        {
            _id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _id_ = node;
    }

    public PArg1 getArg1()
    {
        return _arg1_;
    }

    public void setArg1(PArg1 node)
    {
        if(_arg1_ != null)
        {
            _arg1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _arg1_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_id_)
            + toString(_arg1_);
    }

    void removeChild(Node child)
    {
        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_arg1_ == child)
        {
            _arg1_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(_arg1_ == oldChild)
        {
            setArg1((PArg1) newChild);
            return;
        }

    }
}
