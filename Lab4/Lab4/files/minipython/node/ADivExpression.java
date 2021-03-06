/* This file was generated by SableCC (http://www.sablecc.org/). */

package minipython.node;

import java.util.*;
import minipython.analysis.*;

public final class ADivExpression extends PExpression
{
    private PExpression _firstExpression_;
    private PExpression _followingExpression_;

    public ADivExpression()
    {
    }

    public ADivExpression(
        PExpression _firstExpression_,
        PExpression _followingExpression_)
    {
        setFirstExpression(_firstExpression_);

        setFollowingExpression(_followingExpression_);

    }
    public Object clone()
    {
        return new ADivExpression(
            (PExpression) cloneNode(_firstExpression_),
            (PExpression) cloneNode(_followingExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADivExpression(this);
    }

    public PExpression getFirstExpression()
    {
        return _firstExpression_;
    }

    public void setFirstExpression(PExpression node)
    {
        if(_firstExpression_ != null)
        {
            _firstExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _firstExpression_ = node;
    }

    public PExpression getFollowingExpression()
    {
        return _followingExpression_;
    }

    public void setFollowingExpression(PExpression node)
    {
        if(_followingExpression_ != null)
        {
            _followingExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _followingExpression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_firstExpression_)
            + toString(_followingExpression_);
    }

    void removeChild(Node child)
    {
        if(_firstExpression_ == child)
        {
            _firstExpression_ = null;
            return;
        }

        if(_followingExpression_ == child)
        {
            _followingExpression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_firstExpression_ == oldChild)
        {
            setFirstExpression((PExpression) newChild);
            return;
        }

        if(_followingExpression_ == oldChild)
        {
            setFollowingExpression((PExpression) newChild);
            return;
        }

    }
}
