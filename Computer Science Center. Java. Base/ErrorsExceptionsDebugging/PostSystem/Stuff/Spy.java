package ErrorsExceptionsDebugging.PostSystem.Stuff;

import java.util.logging.Level;
import java.util.logging.Logger;

import ErrorsExceptionsDebugging.PostSystem.Base.Constants;
import ErrorsExceptionsDebugging.PostSystem.Base.MailMessage;
import ErrorsExceptionsDebugging.PostSystem.Base.MailService;
import ErrorsExceptionsDebugging.PostSystem.Base.Sendable;

public class Spy implements MailService {

    private final Logger logger;

    public Spy(Logger someLogger) {
        logger = someLogger;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailMessage) {

            if (mail.getFrom() == Constants.AUSTIN_POWERS || mail.getTo() == Constants.AUSTIN_POWERS) {

                logger.log(Level.WARNING,
                    "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                    new Object[] {
                        mail.getFrom(),
                        mail.getTo(),
                        ((MailMessage) mail).getMessage()
                    }                        
                );

            } else {

                logger.log(Level.INFO,
                    "Usual correspondence: from {0} to {1}",
                    new Object[] {
                        mail.getFrom(),
                        mail.getTo()
                    }                        
                );

            }

        }

        return mail;
    }

}