package ErrorsExceptionsDebugging.PostSystem.Stuff;

import ErrorsExceptionsDebugging.PostSystem.Base.*;

public class UntrustworthyMailWorker implements MailService {

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

        realMailService.processMail(mail);

        return mail;

    }
}