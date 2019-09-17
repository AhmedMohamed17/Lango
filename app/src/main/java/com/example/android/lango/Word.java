package com.example.android.lango;

public class Word {
    private int audio;

    public String getEnglishTranslation() {
        return EnglishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        EnglishTranslation = englishTranslation;
    }

    public String getDefaultTranslation() {
        return DefaultTranslation;
    }

    public int getAudio() {
        return audio;
    }

    public void setDefaultTranslation(String defaultTranslation) {
        DefaultTranslation = defaultTranslation;
    }

    private String EnglishTranslation;
    private String DefaultTranslation;
    private int ImageID;

    public int getImageID() {
        return ImageID;
    }

    public Word(String englishTranslation, String defaultTranslation) {
        EnglishTranslation = englishTranslation;
        DefaultTranslation = defaultTranslation;
    }

    public Word(String englishTranslation, String defaultTranslation, int imageID) {
        EnglishTranslation = englishTranslation;
        DefaultTranslation = defaultTranslation;
        ImageID = imageID;
    }

    public Word(String englishTranslation, String defaultTranslation, int imageID, int audio) {
        this.audio = audio;
        EnglishTranslation = englishTranslation;
        DefaultTranslation = defaultTranslation;
        ImageID = imageID;
    }

    public Word(int audio, String englishTranslation, String defaultTranslation) {
        this.audio = audio;
        EnglishTranslation = englishTranslation;
        DefaultTranslation = defaultTranslation;
    }

}
