package ErrorsExceptionsDebugging.PostSystem.Stuff;

import ErrorsExceptionsDebugging.PostSystem.Base.MailPackage;
import ErrorsExceptionsDebugging.PostSystem.Base.MailService;
import ErrorsExceptionsDebugging.PostSystem.Base.Package;
import ErrorsExceptionsDebugging.PostSystem.Base.Sendable;

public class Thief implements MailService {

    private final int minimum;
    private int stolenValue;

    public Thief(int minPrice) {
        minimum = minPrice;
        stolenValue = 0;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {

            int price = ((MailPackage) mail).getContent().getPrice();

            if (price >= minimum) {

                stolenValue += price;

                return new MailPackage(
                    mail.getFrom(),
                    mail.getTo(),
                    new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0)
                );

            }

        }

        return mail;

    }

    public int getStolenValue() { return stolenValue; }

}