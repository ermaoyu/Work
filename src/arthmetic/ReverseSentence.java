package arthmetic;

public class ReverseSentence {
    /**
     * student. a am I”。
     * 后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。
     * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * */
    public String ReverseSentence(String str) {
        if(str == null||str.trim().equals("")){
            return str;
        }
        String[] words = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < words.length;i++){
            sb.append(reverse1(words[i].toCharArray(),0,words[i].length())).append(" ");
        }
        if (sb.length()>0){
            sb.deleteCharAt(sb.length()-1);// 删除最后一个空格
        }
        return reverse1(sb.toString().toCharArray(),0,sb.length()-1);
    }
    private String reverse1(char[] str, int low, int high) {
        if (low>high){
            return "";
        }
        char tmp;
        while (low<high){
            tmp = str[low];
            str[low] = str[high];
            str[high] = tmp;
            low++;
            high--;
        }
        return String.valueOf(str);
    }
}
