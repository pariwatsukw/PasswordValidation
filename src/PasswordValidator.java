// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;
    
    

    static boolean validate(String pw) {
        if ( pw == null) {
            throw new IllegalArgumentException("paas can not be null");
        }

        if(pw.length()< MIN_LEN|| pw.length()> MAX_LEN){
            return false; 
        }           

       
        boolean hasLower = false;
        boolean hasNumber = false;
        boolean hasUpper = false;

        for(int i = 0;i < pw.length();i++){
            char ch = pw.charAt(i);
            if (ch == ' ') {
                return false;
            }
            
            if (Character.isUpperCase(pw.charAt(i))) hasUpper = true;
            else if (Character.isLowerCase(pw.charAt(i))) hasLower = true;
            else if (Character.isDigit(pw.charAt(i)))hasNumber = true; 
                
             
        }
        
          return hasLower && hasUpper && hasNumber;
    }
}
