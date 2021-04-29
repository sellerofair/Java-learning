package ErrorsExceptionsDebugging.PostSystem;

import java.util.logging.Logger;

import ErrorsExceptionsDebugging.PostSystem.Base.MailMessage;
import ErrorsExceptionsDebugging.PostSystem.Base.MailPackage;
import ErrorsExceptionsDebugging.PostSystem.Base.MailService;
import ErrorsExceptionsDebugging.PostSystem.Base.Package;
import ErrorsExceptionsDebugging.PostSystem.Base.Sendable;
import ErrorsExceptionsDebugging.PostSystem.Stuff.*;

public class Main {
    public static void main(String[] args) {

        Sendable[] mails = new Sendable[] {
            new MailMessage("me", "you", "Hello!"),
            new MailMessage("me", "you", "Bye!"),
            new MailMessage("Austin Powers", "you", "Hello!"),
            new MailMessage("me", "Austin Powers", "Hello!"),
            new MailPackage("me", "you", new Package("weapons", 2000)),
            new MailPackage("me", "you", new Package("gold and diamonds", 10000)),
            new MailPackage("me", "you", new Package("weapons", 12)),
            new MailPackage("me", "you", new Package("flowers", 12)),
            new MailPackage("me", "you", new Package("banned substance", 18))
        };

        Logger LOGGER = Logger.getLogger(Main.class.getName());

        Thief thief = new Thief(20);
        
        MailService[] stuff = new MailService[] {
            new Spy(LOGGER),
            thief,
            new Inspector()    
        };

        UntrustworthyMailWorker bungler = new UntrustworthyMailWorker(stuff);

        for (Sendable mail : mails) {
            System.out.println("\n");
            try {
                bungler.processMail(mail);
            } catch (StolenPackageException e) {
                System.out.println("Stolen Package detected");
            } catch (IllegalPackageException e) {
                System.out.println("Illegal Package detected");
            }
        }

        System.out.println(String.format("\n\nThe Thief stole packages worth %s", thief.getStolenValue()));

    }

}
