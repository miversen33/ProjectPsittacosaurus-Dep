package Utils.XML;

public final class XMLProperty{

    private final String mTitle;
    private final Object mInfo;

    public XMLProperty(final String title, final Object info){
        this.mTitle = title;
        this.mInfo = info;
    }

    @Override
    public final String toString(){
        return mTitle+"="+mInfo.toString();
    }
}