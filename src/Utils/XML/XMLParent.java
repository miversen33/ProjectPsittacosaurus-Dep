package Utils.XML;

import java.util.LinkedList;

public class XMLParent extends XMLEntry{

    private final LinkedList<XMLEntry> mChildren;

    public XMLParent(final String name){
        super(name);
        mChildren = new LinkedList<>();
    }

    protected final void addChild(final XMLEntry child){
        mChildren.add(child);
    }

    protected final XMLEntry getNextChild(){
        return mChildren.pop();
    }

    public final int size(){
        return mChildren.size();
    }

    public final boolean isEmpty(){
        return size() == 0;
    }

}
