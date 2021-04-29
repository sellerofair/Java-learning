package ErrorsExceptionsDebugging.PostSystem.Stuff;

import ErrorsExceptionsDebugging.PostSystem.Base.Constants;
import ErrorsExceptionsDebugging.PostSystem.Base.MailPackage;
import ErrorsExceptionsDebugging.PostSystem.Base.MailService;
import ErrorsExceptionsDebugging.PostSystem.Base.Sendable;

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailPackage) {

            String content = ((MailPackage) mail).getContent().getContent();

            if (content == Constants.WEAPONS || content == Constants.BANNED_SUBSTANCE) { throw new IllegalPackageException(); }
            if (content.startsWith("stones")) { throw new StolenPackageException(); }

        }

        return mail;

    }

}