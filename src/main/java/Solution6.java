import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//在dev分支上，加一行注释 以便形成与main分支的差异
class Solution6 {
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 初始化每个用户的收藏公司集合
        for (int i = 0; i < 105; ++i) {
            s[i] = new HashSet<>();
        }
        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<>();

        // 将每个用户的公司列表转为 Set 存储，便于后续查找
        for (int i = 0; i < n; ++i) {
            for (String com : favoriteCompanies.get(i)) {
                s[i].add(com);
            }
        }

        // 检查每个用户是否是其他用户的子集
        for (int i = 0; i < n; ++i) {
            boolean isSub = false;
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    continue;
                }
                if (check(favoriteCompanies, i, j)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                ans.add(i);
            }
        }

        return ans;
    }

    // 检查 favoriteCompanies[i] 是否是 favoriteCompanies[j] 的子集
    private boolean check(List<List<String>> favoriteCompanies, int x, int y) {
        for (String com : favoriteCompanies.get(x)) {
            if (!s[y].contains(com)) {
                return false;
            }
        }
        return true;
    }
}
