package src.utils;

public class MenuOption {
    public static String numberInRange(String number) {
        if (number == null || number.trim().isEmpty() || !number.matches("[1-6]")) {
            System.out.println("Digite um digito de (1 a 6)");
            return "66666";
        }

        return number;

    }
}