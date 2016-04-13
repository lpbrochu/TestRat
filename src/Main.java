import Rating.RateEngine;
import model.Fingerprint;
import model.PolicyInfo;
import simulator.Simulator;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by lobrochu on 2016-04-12.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Simulator simulator = new Simulator();

        System.out.println("Starting cache");
        long startMillis = System.currentTimeMillis();
        Map<Long, Long> premiumsCache = simulator.run();
        long endMillis = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endMillis - startMillis) + "ms" );
        System.out.println("Number of entries: " + premiumsCache.size() );


        System.in.read();

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(1985, 5, 22);
        PolicyInfo policyInfo = new PolicyInfo();
        policyInfo.setHomeConstructedInYear(1945);
        policyInfo.setBirthDate( cal.getTime() );
        policyInfo.setRebuildingCost( 137000L );

        System.out.println("Searching one premium----" );
        startMillis = System.currentTimeMillis();
        Fingerprint fingerprint = RateEngine.generateFingerprint(policyInfo);
        Long premium = premiumsCache.get(fingerprint.getFingerprint());
        endMillis = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (endMillis - startMillis) + "ms" );
        System.out.println("Hash is: " + fingerprint.getHashString() );
        System.out.println("Fingerprint is: " + fingerprint.getFingerprint() );
        System.out.println("Premium is: " + premium + "$" );
    }


}
