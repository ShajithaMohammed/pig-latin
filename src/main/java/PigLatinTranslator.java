
public class PigLatinTranslator {
    public String translate(String englishWords) {

        String[] wordsInEnglish = englishWords.split(" ");

        String wordsInPigLatin = new String();

        String pigLatin = "";

        String vowels = "aeiou", word = "";
        int indexOfqu, i;
        String temp = "";
        String pigSound = "ay";


        for (int k = 0; k < wordsInEnglish.length; k++) {


            i = 0;
            word = wordsInEnglish[k];


            while (word.length() >= 1) {

                if (vowels.contains("" + word.charAt(i)) || (temp != "" && word.charAt(i) == 'y') || word.substring(i, 2).equals("xr") || word.substring(i, 2).equals("yt")) {
                    wordsInPigLatin = word + temp + pigSound;
                    break;
                } else if (word.charAt(i) == 'q' && (indexOfqu = word.indexOf("qu")) != -1) {
                    wordsInPigLatin = word.substring(indexOfqu + 2) + temp + word.substring(0, indexOfqu + 2) + pigSound;
                    break;
                }

                temp = temp + word.charAt(i);
                word = word.substring(i + 1);

            }

            wordsInEnglish[k] = wordsInPigLatin;
            wordsInPigLatin = "";
            temp = "";
        }


        pigLatin = String.join(" ", wordsInEnglish);

        return pigLatin;
    }
}
