// package com.opsbeach.connect.metrics.service;

// class Solution {
//     public static String mutiplyOneNum(String val, int num) {
//         String result = "";
//         var n = val.length();
//         for (int i=0; i<n; i++) {
//             int num1 = Integer.parseInt(String.valueOf(val.charAt(n-i-1)));
//             String res = String.valueOf(num1*num);
//             result = addTwoString(result, addZeros(res, i));
//         }
//         return result;
//     }

//     public static String addTwoString(String num1, String num2) {
//         if (num1.length() < num2.length()) {
//             var a = num1;
//             num1 = num2;
//             num2 = a;
//         }
//         String result = "";
//         int carry = 0;
//         var n = num2.length();
//         while(n > 0) {
//             var n1 = String.valueOf(num1.charAt(num1.length()-1));  // take last num
//             var n2 = String.valueOf(num2.charAt(n-1));  // take last num
//             var res = Integer.parseInt(n1) + Integer.parseInt(n2) + carry;
//             carry = res/10;
//             result = String.valueOf(res%10) + result;
//             num1 = num1.substring(0, num1.length()-1);
//             num2 = num2.substring(0, n-1);
//             n--;
//         }
//         if (num1.length() > 0 && carry!=0) {
//             var soo = Integer.valueOf(String.valueOf(num1.charAt(num1.length()-1))) + carry;
//             result = String.valueOf(soo) + result;
//             num1 = num1.substring(0, num1.length()-1);
//             carry = 0;
//         }
//         if (num1.length() == 0 && carry!=0) {
//             result = String.valueOf(carry) + result;
//         }
//         if (num1.length() > 0) {
//             result = num1 + result;
//         }
//         return result; 
//     }

//     public static String addZeros(String num, int zeroCount) {
//         while (zeroCount > 0) {
//             num = num + "0";
//             zeroCount--;
//         }
//         return num;
//     }

    

//     public static String multiply(String num1, String num2) {
//         if (num1.length() < num2.length()) {
//             var a = num1;
//             num1 = num2;
//             num2 = a;
//         }
//         String result = "";
//         int n = num2.length();
//         String[] values = new String[n];
//         for (int i=0; i<n; i++) {
//             var lst = Integer.parseInt(String.valueOf(num2.charAt(n-i-1)));
//             var res = mutiplyOneNum(num1, lst);
//             result = addTwoString(result, addZeros(res, i));
//             values[i] = res;
//         }
//         String result2 = "";
//         for (String val : values) {
//             result2 = addTwoString(result2, val);
//         }
//         while (true) {
//             if (result.charAt(0) == '0') {
//                 if (result.length() == 1) {
//                     result = "0";
//                     break;
//                 }
//                 result = result.substring(1, result.length());
//             } else {
//                 break;
//             }
//         }
//         return result;
//     }
    
//     public static void main(String[] args) {
//         System.out.println(addTwoString("262156", "655390"));
//         System.out.println(multiply("65539", "83314"));
//     }
// }

// //     262156
// //     655390
// //   19661700
// //  196617000
// // 5243120000
// // ----------
// // 5460316246