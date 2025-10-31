public class EffectcmString {
    private static final char[] CH = {'c', 'm'};

    public static void main(String[] args) {
        EffectcmString effectcmString = new EffectcmString();
        effectcmString.generate(4);
    }

    public void generate(int n) {
        char[] path = new char[n];
        dfs(path, 0, n);
    }

    private void dfs(char[] path, int pos, int n) {
        if (pos == n) {
            System.out.println(new String(path));
            return;
        }
        for (char c : CH) {
            path[pos] = c;
            dfs(path, pos + 1, n);
        }
    }
}
