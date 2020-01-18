/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AFunctionCallFunctionCall extends PFunctionCall
{
    private TId _id_;
    private PArglist _arglist_;

    public AFunctionCallFunctionCall()
    {
    }

    public AFunctionCallFunctionCall(
        TId _id_,
        PArglist _arglist_)
    {
        setId(_id_);

        setArglist(_arglist_);

    }
    public Object clone()
    {
        return new AFunctionCallFunctionCall(
            (TId) cloneNode(_id_),
            (PArglist) cloneNode(_arglist_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionCallFunctionCall(this);
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

    public PArglist getArglist()
    {
        return _arglist_;
    }

    public void setArglist(PArglist node)
    {
        if(_arglist_ != null)
        {
            _arglist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _arglist_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_id_)
            + toString(_arglist_);
    }

    void removeChild(Node child)
    {
        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_arglist_ == child)
        {
            _arglist_ = null;
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

        if(_arglist_ == oldChild)
        {
            setArglist((PArglist) newChild);
            return;
        }

    }
}
