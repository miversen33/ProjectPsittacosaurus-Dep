package Utils.XML;

import java.util.ArrayList;
import java.util.List;

public class XMLEntry implements XMLStrings{
    private final String mLabel;
    private List<XMLProperty> mProperties;
    private List<Object> mChildren;
    private XMLEntry mParent = null;

    private boolean isOpen = true;

    public XMLEntry(final String label) {
        mLabel = label;
        mProperties = new ArrayList<>();
        mChildren = new ArrayList<>();
    }

    public final boolean hasParent(){
        return mParent != null;
    }

    public final void setParent(final XMLEntry parent){
        if(mParent != null){
            // TODO
            // LOG INVALID PARENT OVERRIDE
            System.out.println("Cannot overwrite parent for "+mLabel);
            return;
        }
        mParent = parent;
    }

    public final XMLEntry getParent(){
        return mParent;
    }

    public final int size(){
        return mChildren.size();
    }

    public final boolean isEmpty(){
        return size() == 0;
    }

    public final boolean isOpen(){
        return this.isOpen;
    }

    public final void finalize(){
        isOpen = false;
    }

    public final void addProperty(final XMLProperty property){
        if(!isOpen()) return;
        mProperties.add(property);
    }

    public final void addChild(final Object child){
        int i = 0;
        this.mChildren.add(child);
        i = 1;
    }

    public final String getLabel(){
        return mLabel;
    }

    public final String getCloseLabel(){
        return CLOSE_BRACKET_WITH_TITLE+mLabel+OPEN_END_BRACKET;
    }

    public final String getOpenLabel(){
        return BEGIN_BRACKET+mLabel;
    }

    public final String parseToXML(){
        String xml = getOpenLabel();
        for(final XMLProperty property : mProperties){
            xml += LINE_BREAK;
            xml += property.toString();
        }
        xml += OPEN_END_BRACKET;
        while(!mChildren.isEmpty()){
            xml += mChildren.get(0).toString();
            mChildren.remove(0);
        }

        return xml;
    }

    @Override
    public final String toString(){
        return parseToXML();
    }

}