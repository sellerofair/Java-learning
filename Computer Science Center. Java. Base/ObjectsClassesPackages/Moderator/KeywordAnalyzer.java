package ObjectsClassesPackages.Moderator;

abstract class KeywordAnalyzer implements TextAnalyzer{

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String keyword : getKeywords()) {
            if (text.indexOf(keyword) != -1) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}