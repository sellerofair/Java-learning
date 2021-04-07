package ObjectsClassesPackages.Moderator;

class SpamAnalyzer extends KeywordAnalyzer {
    
    private String[] keywords;

    public SpamAnalyzer(String[] _keywords) {
        keywords = new String[_keywords.length];
        for (int i = 0; i < keywords.length; i++) {
            keywords[i] = _keywords[i];
        }
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }

}