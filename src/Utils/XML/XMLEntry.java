package Utils.XML;

public class XMLEntry implements XMLStrings{

    private final String mLabel;
    private final String mInfo;
    private final boolean mIsParent;

    protected XMLEntry(final String label){
        mLabel = label;
        mInfo = "";
        mIsParent = true;
    }

    public XMLEntry(final String label, final Object info){
        mLabel = label;
        mInfo = info.toString();
        mIsParent = false;
    }

    public final String getLabel(){
        return mLabel;
    }

    public final String getInfo(){
        return mInfo;
    }

    public final boolean isParent(){
        return mIsParent;
    }

    public final String parseToXML(){
        if(isParent()) return parseAsParent();
        return parseAsChild();
    }

    public final String getCloseLabel(){
        return CLOSE_BRACKET_WITH_TITLE+mLabel+ OPEN_END_BRACKET;
    }

    private final String parseAsChild(){
        return parseAsParent()+QUOTATION+mInfo+QUOTATION+getCloseLabel();
    }

    private final String parseAsParent(){
        return getXMLLabel()+ OPEN_END_BRACKET;
    }

    private final String getXMLLabel(){
        return BEGIN_BRACKET+mLabel;
    }

}
