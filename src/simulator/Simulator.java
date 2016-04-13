package simulator;

import Rating.RateEngine;
import com.planetj.math.rabinhash.RabinHashFunction64;
import model.Fingerprint;
import model.PolicyInfo;
import model.RatingResult;

import java.util.*;

/**
 * Created by lobrochu on 2016-04-12.
 */
public class Simulator {
    private RateEngine rateEngine = new RateEngine();
    private Map<Long, Long> premiumsCache = new HashMap<Long, Long>();

    public Map<Long, Long> run() {

        //private String postalCode;

        //private Date dateMovedIn;

        //private Boolean creditConsent;

        //private CodeValue numberOfMortgageOnHome;

        //private CodeValue numberOfYearsPreviouslyInsured;

        final PolicyInfo policyInfo = new PolicyInfo();
        long count = 0;

        for (int homeConstructed=1900; homeConstructed < 2016; homeConstructed++)
        {
            policyInfo.setHomeConstructedInYear(homeConstructed);

            for (long rebuildingCost=50000L; rebuildingCost < 500000; rebuildingCost+=1000)
            {
                policyInfo.setRebuildingCost(rebuildingCost);

                for (int age=14; age < 100; age++)
                {
                    final Calendar cal = GregorianCalendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    cal.set(Calendar.YEAR, year - age);
                    policyInfo.setBirthDate(cal.getTime());

                    RatingResult ratingResult = rateEngine.rateContract(policyInfo);

                    //byte[] bytes = RateEngine.generateFingerprintString(policyInfo);
                    Fingerprint fingerprint = RateEngine.generateFingerprint(policyInfo);

                    if ( fingerprint.getHashString().equals("28|1977|253000") )
                    {
                        System.out.println("Test case!!!: " + count + ", hash: " + fingerprint.getHashString() + ", key: " + fingerprint.getFingerprint() + ", premium: " + ratingResult.getPremium());
                    }

                    Long premium = ratingResult.getPremium();
                    premiumsCache.put( fingerprint.getFingerprint(), premium );
                    count++;
                    if ( count % 1000 == 0) {
                        System.out.println("Processing: " + count + ", hash: " + fingerprint.getHashString() + ", key: " + fingerprint.getFingerprint() + ", premium: " + ratingResult.getPremium());
                    }
                }
            }
        }

        return premiumsCache;
    }

}
