package ValidateIPAddress;

/**
 * 468. Validate IP Address
 *
 * In this problem, your job to write a function
 * to check whether a input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPV4
 * IPv4 addresses are canonically represented in dot-decimal notation,
 * which consists of four decimal numbers,
 * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * leading zeros in the IPv4 is illegal.
 *
 * IPV6
 * IPv6 addresses are represented as eight groups of four hexadecimal digits,
 * each group representing 16 bits. The groups are separated by colons (":").
 * we could omit some leading zeros among four hexadecimal digits
 * and some low-case characters in the address to upper-case ones,
 * so 2001:db8:85a3:0:0:8A2E:0370:7334
 *
 * However, we don't replace a consecutive group of zero value
 * with a single empty group using two consecutive colons (::) to pursue simplicity.
 * 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * extra leading zeros in the IPv6 is also illegal.
 *
 * You could assume there is no extra space in the test cases
 * and there may some special characters in the input string.
 *
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        else if (IP.contains(".") && validIPV4Address(IP)) {
            return "IPv4";
        }
        else if (IP.contains(":") && validIPV6Address(IP)) {
            return "IPv6";
        }
        else {
            return "Neither";
        }
    }

    private boolean validIPV4Address(String IP) {
        String[] segments = IP.split("[.]");
        if (segments.length != 4 || IP.startsWith(".") || IP.endsWith(".")) {
            return false;
        }

        for (String segment : segments) {
            if (segment.length() == 0 || segment.length() > 3 || (segment.length() != 1 && segment.charAt(0) == '0')) {
                return false;
            }

            int i = 0;
            int num = 0;
            while (i < segment.length()) {
                if (!Character.isDigit(segment.charAt(i))) {
                    return false;
                }
                num = 10*num+(segment.charAt(i++)-'0');
            }

            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean validIPV6Address(String IP) {
        IP = IP.toLowerCase();
        String[] segments = IP.split("[:]");
        if (segments.length != 8 || IP.startsWith(":") || IP.endsWith(":")) {
            return false;
        }

        for (String segment : segments) {
            if (segment.length() == 0 || segment.length() > 4) {
                return false;
            }

            int num = 0;
            for (char c : segment.toCharArray()) {
                if (Character.isDigit(c)) {
                    num = 16*num + (c-'0');
                }
                else if (c <= 'f' && c >= 'a') {
                    num = 16*num + (c-'a');
                }
                else {
                    return false;
                }
            }

            if (num > 65536) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] IPs = {
                        "172.16.254.1", "172.16.0.1", "172.16.254.01", "172.16..1", "172.16.254", ""
                        ,"2001:0db8:85a3:0000:0000:8a2e:0370:7334"
                        ,"2001:0db8:85a3:00:0000:8a2e:0370:7334"
                        ,"2001:0db8:85a3:0:0000:8a2e:0370:7334"
                        ,"2001:0db8:85a3::0000:8a2e:0370:7334"
                        ,"2001:0db8:ffff:0000:0000:8a2e:0370:7334"
                        ,"2001:0db8:gggg:0000:0000:8a2e:0370:7334"
                        ,"02001:0db8:85a3:0000:0000:8a2e:0370:7334"
                        ,"12001:0db8:85a3:0000:0000:8a2e:0370:7334"
                        ,"2001:85a3:0000:0000:8a2e:0370:7334"
                        ,"0:0:0:0:0:0:0:0"
                        ,"1.1.1.1."
                        ,"111111.111111.11111.11111."};
        for (String IP : IPs) {
            System.out.println(new ValidateIPAddress().validIPAddress(IP));
        }
    }
}
