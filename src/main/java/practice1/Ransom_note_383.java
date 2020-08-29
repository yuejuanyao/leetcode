package practice1;

public class Ransom_note_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() <= 0)
            return true;
        if (magazine == null || magazine.length() < ransomNote.length())
            return false;
        int[] hash = new int[26];
        for (char c : magazine.toCharArray())
            hash[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (hash[c - 'a'] == 0)
                return false;
            else {
                hash[c - 'a']--;
            }
        }
        return true;
    }

    public boolean canConstruct_1(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() <= 0)
            return true;
        if (magazine == null || magazine.length() < ransomNote.length())
            return false;
        int[] hash = new int[26];
        for (char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c, hash[c-'a']);
            if (index == -1)
                return false;
            hash[c-'a'] = index +1;
        }
        return true;
    }
}
