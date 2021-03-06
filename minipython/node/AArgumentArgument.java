/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class AArgumentArgument extends PArgument
{
    private TId _id_;
    private PArg1 _arg1_;
    private final LinkedList _arg2_ = new TypedLinkedList(new Arg2_Cast());

    public AArgumentArgument()
    {
    }

    public AArgumentArgument(
        TId _id_,
        PArg1 _arg1_,
        List _arg2_)
    {
        setId(_id_);

        setArg1(_arg1_);

        {
            this._arg2_.clear();
            this._arg2_.addAll(_arg2_);
        }

    }
    public Object clone()
    {
        return new AArgumentArgument(
            (TId) cloneNode(_id_),
            (PArg1) cloneNode(_arg1_),
            cloneList(_arg2_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArgumentArgument(this);
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

    public LinkedList getArg2()
    {
        return _arg2_;
    }

    public void setArg2(List list)
    {
        _arg2_.clear();
        _arg2_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_id_)
            + toString(_arg1_)
            + toString(_arg2_);
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

        if(_arg2_.remove(child))
        {
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

        for(ListIterator i = _arg2_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class Arg2_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PArg2 node = (PArg2) o;

            if((node.parent() != null) &&
                (node.parent() != AArgumentArgument.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AArgumentArgument.this))
            {
                node.parent(AArgumentArgument.this);
            }

            return node;
        }
    }
}
