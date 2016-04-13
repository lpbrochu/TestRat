package Rating;

import com.planetj.math.rabinhash.RabinHashFunction64;
import model.Fingerprint;
import model.PolicyInfo;
import model.RatingResult;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by lobrochu on 2016-04-12.
 */
public class RateEngine {

    public RatingResult rateContract(PolicyInfo policyInfo)
    {
        Long premium = 1000L;

        if (policyInfo.getRebuildingCost() < 50000)
            premium += 10;
        else if (policyInfo.getRebuildingCost() < 100000)
            premium += 100;
        else
            premium += 200;

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(policyInfo.getBirthDate());
        premium += GregorianCalendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);

        RatingResult ratingResult = new RatingResult(premium);
        return ratingResult;
    }

    public static Fingerprint generateFingerprint(PolicyInfo policyInfo)
    {
        StringBuffer buffer = new StringBuffer();
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(policyInfo.getBirthDate());
        int age = GregorianCalendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        buffer.append(age);
        buffer.append("|");
//        buffer.append(policyInfo.getCreditConsent());
//        buffer.append(policyInfo.getDateMovedIn());
        buffer.append(policyInfo.getHomeConstructedInYear());
        buffer.append("|");
//        buffer.append(policyInfo.getNumberOfMortgageOnHome());
//        buffer.append(policyInfo.getNumberOfYearsPreviouslyInsured());
//        buffer.append(policyInfo.getPostalCode());

        buffer.append((policyInfo.getRebuildingCost() / 1000) * 1000);
        String hashString = buffer.toString();

        RabinHashFunction64 rabinHash = RabinHashFunction64.DEFAULT_HASH_FUNCTION;
        return new Fingerprint(rabinHash.hash(hashString), hashString);
    }

    public static byte[] generateFingerprintString(PolicyInfo policyInfo)
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(policyInfo.getBirthDate());
        buffer.append(policyInfo.getCreditConsent());
        buffer.append(policyInfo.getDateMovedIn());
        buffer.append(policyInfo.getHomeConstructedInYear());
        buffer.append(policyInfo.getNumberOfMortgageOnHome());
        buffer.append(policyInfo.getNumberOfYearsPreviouslyInsured());
        buffer.append(policyInfo.getPostalCode());
        buffer.append(policyInfo.getRebuildingCost());

        byte[] bytes = DigestUtils.md5(buffer.toString());

        return bytes;
    }
}
