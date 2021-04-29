package ErrorsExceptionsDebugging.PostSystem.Base;

/*
Класс, в котором скрыта логика настоящей почты
*/
public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {

    // Добавлена имитация работы почты для тестирования (в условии задычи был пустой метод).

        StringBuilder message = new StringBuilder();

        if (mail instanceof MailMessage) {

            MailMessage mailMessage = (MailMessage) mail;

            message.append("Message from ");
            message.append(mailMessage.getFrom());
            message.append(" to ");
            message.append(mailMessage.getTo());
            message.append(":\n\"");
            message.append(mailMessage.getMessage());
            message.append("\"\n\nSent successfully.");

        } else {

            MailPackage mailPackage = (MailPackage) mail;

            message.append("Package from ");
            message.append(mailPackage.getFrom());
            message.append(" to ");
            message.append(mailPackage.getTo());
            message.append(" cost ");
            message.append(mailPackage.getContent().getPrice());
            message.append(":\n\"");
            message.append(mailPackage.getContent().getContent());
            message.append("\"\n\nSent successfully.");

        }

        System.out.println(message.toString());
        return mail;

    }
}