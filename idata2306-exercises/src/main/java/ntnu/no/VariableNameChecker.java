package ntnu.no;

public class VariableNameChecker {

    // Method to check if a variable name is valid
    public static boolean isValidVariableName(String name) {
        // Check if the name is empty, starts with a digit, or starts with an underscore
        if (name.isEmpty() || Character.isDigit(name.charAt(0)) || name.charAt(0) == '_') {
            return false;
        }

        // Check each character in the name
        for (char character : name.toCharArray()) {
            // Check if the character is a valid character (letter, digit, underscore, or dollar sign)
            if (!Character.isLetterOrDigit(character) && character != '_' && character != '$') {
                return false;
            }
        }

        // Check if the name is a reserved keyword in Java
        if (isReservedKeyword(name)) {
            return false;
        }

        // If all checks pass, the name is valid
        return true;
    }

    // Method to check if a name is a reserved keyword in Java
    public static boolean isReservedKeyword(String name) {
        String[] reservedKeywords = {
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
                "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
                "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        for (String keyword : reservedKeywords) {
            if (keyword.equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // List of variable names to check
        String[] variableNames = {
                "8","Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "JuliaZ007", "Julia@007", "_Julia007"
        };

        // Check each name and print whether it is valid or invalid
        for (String name : variableNames) {
            if (isValidVariableName(name)) {
                System.out.println(name + " -> Valid");
            } else {
                System.out.println(name + " -> Invalid");
            }
        }
    }
}