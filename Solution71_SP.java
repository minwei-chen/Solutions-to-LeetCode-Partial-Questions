import java.util.ArrayList;
import java.util.List;


public class Solution71_SP {

    public String simplifyPath(String path) {
        String tokens[] = path.split("/"), rs = "";
        int len = tokens.length;
        List<String> list = new ArrayList<>(len);
        for(String s: tokens) {
        	if(s.equals("..") && list.size()>0) list.remove(list.size()-1);
        	else if(!s.equals("..") && !s.equals(".") && !s.equals("")) list.add(s);
        }
        for(String s: list) {
        	rs += "/"+s;
        }
        if(rs.equals("")) rs = "/";
        return rs;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution71_SP().simplifyPath("/..");
	}

}
