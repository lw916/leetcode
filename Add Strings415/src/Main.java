// 可用于字符串加法，链表加法和二进制加法
// 利用的是字符串与ascii的'0'的差值求大小
class Solution {
    public String addStrings(String num1, String num2) {
        int temp = 0;
        StringBuilder string = new StringBuilder();
        int x = num1.length() - 1;
        int y = num2.length() - 1;
        while( x >= 0 || y >= 0 || temp != 0){
            if( x >= 0 ) temp += num1.charAt(x--) - '0';
            if( y >= 0 ) temp += num2.charAt(y--) - '0';
            string.append(temp%10);
            temp /= 10;
        }
        return string.reverse().toString(); // reverse字符串反转
    }

}