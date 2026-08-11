package Lab06.training.utils;

import java.util.Arrays;
import java.util.HashSet;

public final class Validator {
    private Validator(){}

    public static boolean validateCode(String code){
        return code != null && code.matches(Constants.COURSE_CODE_REGEX);
    }

    public static boolean isDuplicatedCode(String code, HashSet<String> codeSet){
        return codeSet.contains(code.toUpperCase());
    }

    public static boolean validateFlag(String flag){
        if(flag == null) return false;
        String normalizedFlag = flag.trim();
        return Arrays.stream(Constants.ALLOWED_FLAGS).anyMatch(a -> a.equalsIgnoreCase(normalizedFlag));
    }

    public static boolean validateDuration(short duration){
        return duration > 0;
    }
}
