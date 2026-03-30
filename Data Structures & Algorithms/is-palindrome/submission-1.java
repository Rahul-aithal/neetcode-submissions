class Solution {
    public boolean isPalindrome(String s) {
        int index=0;
     s= s.replace(" ","");
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
            
//             if ( Character.isLetterOrDigit(ch)) {
//                 System.out.println(ch);
//                 continue;
// } else{ 
// System.out.println(ch);

//   s=  s.replace(ch+"","");}
// }
s=s.toLowerCase();
int left=0;
int right=s.length()-1;
System.out.println(s);
while(left<=right){
    while(!Character.isLetterOrDigit(s.charAt(left))&&left<right){
        left++;
    }
        while(!Character.isLetterOrDigit(s.charAt(right))&&left<right){
        right--;
    }
    if(s.charAt(left)==s.charAt(right)){
        left++;
        right--;
    }else{
        return false;
    }
}
return true;
        }
}

