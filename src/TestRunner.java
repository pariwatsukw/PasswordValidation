// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)

        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("password len = 8",PasswordValidator.validate("Aabcse12")==true);
        check("password len < 8",PasswordValidator.validate("Aabcse1")==false);
        check("password len >20",PasswordValidator.validate("Aabcse12safaasfassfasfas")==false);
        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("password no upper ",PasswordValidator.validate("aaaaabbb1234")==false);
        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("password no downner",PasswordValidator.validate("POQJASDI45876")==false);
        // TODO: R5 - ไม่มีตัวเลข -> false
        check("password no number",PasswordValidator.validate("AJFYlsihd")==false);
        // TODO: R6 - มีช่องว่าง -> false
        check("password space",PasswordValidator.validate("AJ lsihd")==false);
        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
        check("password all space",PasswordValidator.validate("         ")==false);
        
        check("password Spacial char",PasswordValidator.validate("AJ_dj$ihd")==false);
        check("password null",PasswordValidator.validate("sdfdsf56954")==false);
        check("password no",PasswordValidator.validate("")==false);
        


        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
