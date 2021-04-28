package ErrorsExceptionsDebugging.PostSystem;

import java.util.logging.*;

import ErrorsExceptionsDebugging.PostSystem.Base.*;
import ErrorsExceptionsDebugging.PostSystem.Base.Package;

public class Main {

    public static void main(String[] args) {
        MailMessage hello = new MailMessage("me", "you", "Hello!");
        MailMessage bye = new MailMessage("me", "you", "Bye!");
        MailMessage fromAP = new MailMessage("Austin Powers", "you", "Hello!");
        Logger LOGGER = Logger.getLogger(Main.class.getName());
        
        Spy anySpy = new Spy(LOGGER);

        anySpy.processMail(hello);
        anySpy.processMail(bye);
        anySpy.processMail(fromAP);
    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static class UntrustworthyMailWorker implements MailService {

        private final RealMailService realMailService;
        private final MailService[] thirdParties;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            thirdParties = mailServices;
            realMailService =  new RealMailService();
        }

        public RealMailService getRealMailService() { return realMailService; }

        @Override
        public Sendable processMail(Sendable mail) {

            for (MailService party : thirdParties) {
                mail = party.processMail(mail);
            }

            return mail;

        }
    }

    public static class Spy implements MailService {

        private final Logger logger;

        public Spy(Logger someLogger) {
            logger = someLogger;
        }

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailMessage) {

                if (mail.getFrom() == AUSTIN_POWERS) {

                    logger.log(Level.WARNING,
                        "Detected target mail correspondence: from " +
                        AUSTIN_POWERS +
                        " to " +
                        mail.getTo() + 
                        " " +
                        ((MailMessage) mail).getMessage()
                    );

                } else {

                    logger.log(Level.INFO,
                        "Usual correspondence: from " +
                        mail.getFrom() +
                        " to " +
                        mail.getTo()
                    );

                }

            }

            return mail;
        }

    }

    public static class Thief implements MailService {

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

    public static class Inspector implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {

            if (mail instanceof MailPackage) {

                String content = ((MailPackage) mail).getContent().getContent();

                if (content == WEAPONS || content == BANNED_SUBSTANCE) { throw new IllegalPackageException(); }
                if (content.startsWith("stones")) { throw new StolenPackageException(); }

            }

            return mail;

        }

    }

    public static class IllegalPackageException extends RuntimeException {}

    public static class StolenPackageException extends RuntimeException {}

}
