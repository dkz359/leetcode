//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
//
// Related Topics 字符串 👍 352 👎 0


package leetcode.editor.cn;

/**
 * 替换空格
 * @author dukz
 * @date 2022-09-26 20:46:06
 */
public class PJZOffer05_TiHuanKongGeLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new PJZOffer05_TiHuanKongGeLcof().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
		int len = s.length();
		StringBuffer sb = new StringBuffer(len);
		for (int i = 0; i < len; i++) {
			char charAt = s.charAt(i);
			if(charAt == ' '){
				sb.append("%20");
			}else{
				sb.append(charAt);
			}
		}
		return sb.toString();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
