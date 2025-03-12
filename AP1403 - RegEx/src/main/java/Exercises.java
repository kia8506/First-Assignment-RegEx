import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    public boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public String findDate(String string) {
        String reg = "\\b(\\d{2})/(\\d{2})/(\\d{4})\\b";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find())
            return matcher.group();
        
        return null;
    }

    public int findValidPasswords(String string) {
        String reg = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        if (count == 0)
            return -1;
        else
            return count;
    }

    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String reg = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                list.add(word);
            }
        }
        return list;
    }

    // Private method to check if a word is a palindrome
    private boolean isPalindrome(String word) {
        String lower_word = word.toLowerCase();
        return lower_word.equals(new StringBuilder(lower_word).reverse().toString());
    }

    public static void main(String[] args) {
        Exercises ex = new Exercises();

        System.out.println(ex.validateEmail("kia@sheikhi.com")); // true
        System.out.println(ex.validateEmail("komkomcerecre")); // false

        System.out.println(ex.findDate("Today is 12/03/2025.")); // 12/03/2025
        System.out.println(ex.findDate("Not any date here.")); // null

        System.out.println(ex.findValidPasswords("Pass@word1 StrongP@ssword2 weakpass 12345678")); // 2

        System.out.println(ex.findPalindromes("asa level noon racar test mkmos")); // [asa, level, noon, racar]
    }
}