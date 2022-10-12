class Main {

  // Given two strings containing backspaces (identified by the character ‘#’),
  // check if the two strings are equal.

  // Example 1:

  // Input: str1="xy#z", str2="xzz#"
  // Output: true
  // Explanation: After applying backspaces the strings become "xz" and "xz"
  // respectively.
  // Example 2:

  // Input: str1="xy#z", str2="xyz#"
  // Output: false
  // Explanation: After applying backspaces the strings become "xz" and "xy"
  // respectively.
  // Example 3:

  // Input: str1="xp#", str2="xyz##"
  // Output: true
  // Explanation: After applying backspaces the strings become "x" and "x"
  // respectively.
  // In "xyz##", the first '#' removes the character 'z' and the second '#'
  // removes the character 'y'.
  // Example 4:

  // Input: str1="xywrrmp", str2="xywrrmu#p"
  // Output: true
  // Explanation: After applying backspaces the strings become "xywrrmp" and
  // "xywrrmp" respectively.

  private static boolean compareStringsWithBackspace(String string1, String string2) {
    int i = string1.length() - 1, j = string2.length() - 1;
    int skipString1 = 0;
    int skipString2 = 0;
    while (i >= 0 || j >= 0) {
      while (i >= 0) { // Find position of next possible char in build(string1)
        if (string1.charAt(i) == '#') {
          skipString1++;
        } else if (skipString1 > 0) {
          skipString1--;
        } else
          break;
        i--;
      }
      while (j >= 0) { // Find position of next possible char in build(string2)
        if (string2.charAt(j) == '#') {
          skipString2++;
        } else if (skipString2 > 0) {
          skipString2--;
        } else
          break;
        j--;
      }
      // If two actual characters are different
      if (string1.charAt(i) != string2.charAt(j))
        return false;
      if (i < 0 && j < 0)
        return true;
      if (i < 0 || j < 0)
        return false;
      i--;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(Main.compareStringsWithBackspace("xy#z", "xzz#"));
    System.out.println(Main.compareStringsWithBackspace("xy#z", "xyz#"));
    System.out.println(Main.compareStringsWithBackspace("xp#", "xyz##"));
    System.out.println(Main.compareStringsWithBackspace("xywrrmp", "xywrrmu#p"));

  }
}