package model;

/**
 * Created by lobrochu on 2016-04-12.
 */
public class Fingerprint {
    private Long fingerprint;
    private String hashString;

    public Fingerprint(Long fingerprint, String hashString)
    {
        this.fingerprint = fingerprint;
        this.hashString = hashString;
    }

    public Long getFingerprint() {
        return fingerprint;
    }

    public String getHashString() {
        return hashString;
    }
}
