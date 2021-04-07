package ObjectsClassesPackages.Moderator;

public class Main {
    public static void main(String[] args) {

        String[] inputText = {
                "Эта строка не пройдёт проверку на длину в 3-м по счету анализаторе",
                "Реклама. Предлагаем купить квартиру! (2-й анализатор ругнётся)",
                "Не грусти :(, мышкой похрусти! (1-й)",
                "Здесь всё ОК"
            };

        NegativeTextAnalyzer negative = new NegativeTextAnalyzer();
        SpamAnalyzer spam = new SpamAnalyzer(new String[]{"купить", "продать"});
        TooLongTextAnalyzer tolong = new TooLongTextAnalyzer(15);

        TextAnalyzer[] moderation = new TextAnalyzer[] {negative, spam, tolong};

        for (String text : inputText) {
            System.out.println(checkLabels(moderation, text));
        }
    }

    /**
     * 
     * Check text in analyzers.
     * 
     * @param analyzers in array
     * @param text for checking
     * @return label after checking
     */
    static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label currentLabel = analyzer.processText(text);
            if (currentLabel != Label.OK) {
                return currentLabel;
            }
        }
        return Label.OK;
    }
}
