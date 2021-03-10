package algorithms.decryptpassword;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Result {

  /*
   * Complete the 'decryptPassword' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */
  public static String decryptPassword(String s) {
    List<Character> chars = getListOfChars(s);

    for (int i = 1; i < chars.size(); i++) {
      Character currentChar = chars.get(i);
      if (currentChar == '*' && i >= 2 && Character.isUpperCase(chars.get(i - 2)) && Character.isLowerCase(chars.get(i - 1))) {
        char temp = chars.get(i - 1);
        chars.set(i - 1, chars.get(i - 2));
        chars.set(i - 2, temp);
        chars.remove(i);
        i--;
      }
    }

    for (int i = chars.size() - 1; i >= 0; i--) {
      Character currentChar = chars.get(i);
      if (currentChar == '0') {
        chars.set(i, chars.get(0));
        chars.remove(0);
      }
    }

    return chars.stream().map(Object::toString).collect(Collectors.joining());
  }

  private static List<Character> getListOfChars(String s) {
    List<Character> chars = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      chars.add(s.charAt(i));
    }
    return chars;
  }
}
