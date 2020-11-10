package challenges.datereformat;

import java.util.*;

public class DateFormat {
    public static List<String> reformatDates(List<String> dates) {
        List<String> outputMon = new ArrayList<>();
        for (String date : dates
        ) {
            if (Integer.parseInt(date.split(" ")[2]) <= 2100 && Integer.parseInt(date.split(" ")[2]) > 1900) {
                String day = date.split(" ")[0];
                String month = "";
                if (!Character.isDigit(day.charAt(1))) {
                    day = day.substring(0, 2);
                } else {
                    day = "0" + day.charAt(0);
                }
                switch (date.split(" ")[1]) {
                    case "Jan":
                        month = "01";
                        break;
                    case "Feb":
                        month = "02";
                        break;
                    case "Mar":
                        month = "03";
                        break;
                    case "Apr":
                        month = "04";
                        break;
                    case "May":
                        month = "05";
                        break;
                    case "Jun":
                        month = "06";
                        break;
                    case "Jul":
                        month = "07";
                        break;
                    case "Aug":
                        month = "08";
                        break;
                    case "Sep":
                        month = "09";
                        break;
                    case "Oct":
                        month = "10";
                        break;
                    case "Nov":
                        month = "11";
                        break;
                    case "Dec":
                        month = "12";
                        break;

                }
                StringBuilder newDate = new StringBuilder(date.split(" ")[2]);
                newDate.append("-")
                        .append(month)
                        .append("-")
                        .append(day);
                outputMon.add(newDate.toString());
            } else {
                System.out.println("invalid date !!");
            }
        }
        return outputMon;
    }


    String reverse(String s) {
        char[] chars = s.toCharArray();//sa-fv
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetter(chars[i])) i++;
            else if (!Character.isLetter(chars[j])) j--;
            else {
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 1;
        String[] sentences = sentence.split(" ");
        for (String sen : sentences
        ) {
            if (sen.startsWith(searchWord)) return i;
            i++;
        }
        return -1;
    }

    public String destCity(List<List<String>> paths) {
//        paths = [["B","C"],["D","B"],["C","A"]]
//        B - D - C
        Set<String> cities = new HashSet<>();
        paths.forEach(strings -> {
            cities.add(strings.get(0));
        });

        for (List<String> path : paths
        ) {
            if (!cities.contains(path.get(1))) return path.get(1);
        }
        return null;
    }

    public boolean isValid(String s) {
//        {(}
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                characters.push(s.charAt(i));
            } else {
                if (characters.isEmpty()) return false;
                char expected = 0;
                char current = characters.peek();
                switch (current) {
                    case '(':
                        expected = ')';
                        break;
                    case '{':
                        expected = '}';
                        break;
                    case '[':
                        expected = ']';
                        break;
                }
                if (s.charAt(i) == expected) {
                    characters.pop();
                } else return false;
            }
        }
        if (characters.empty()) return true;
        else return false;
    }

    public boolean isLongPressedName(String name, String typed) {
        String newName = "";
        for(int i=0;i<typed.length();i++){
            if (!newName.contains(String.valueOf(typed.charAt(i)))){
                newName += String.valueOf(typed.charAt(i));
            }
        }
        return newName.equals(name);
    }

    public static void main(String[] args) {
        DateFormat format = new DateFormat();
        System.out.println(format.isLongPressedName("ali","aaaliii"));
    }
}
