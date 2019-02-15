package Utils;

import java.util.UUID;

public final class Signature {

    private final UUID mSig;

    private Signature(){
        mSig = UUID.randomUUID();
    }

    public static final Signature GenerateNewSignature(){
        return new Signature();
    }

    public static final boolean ValidateSignatures(final Signature firstSig, final Signature secondSig){
        return firstSig.equals(secondSig);
    }
}
