class Solution {
    private class Node {
        int lRun, rRun, maxRun;
        char leftChar, rightChar;
        int len;
        Node(int lRun, int rRun, int maxRun, char leftChar, char rightChar, int len) {
            this.lRun = lRun; this.rRun = rRun; this.maxRun = maxRun;
            this.leftChar = leftChar; this.rightChar = rightChar; this.len = len;
        }
    }

    private Node[] seg;
    private char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length(), k = queryIndices.length;
        arr = s.toCharArray();
        seg = new Node[4*n];
        build(1,0,n-1);

        int[] ans = new int[k];
        for (int i=0;i<k;i++) {
            update(1,0,n-1,queryIndices[i],queryCharacters.charAt(i));
            ans[i] = seg[1].maxRun;
        }
        return ans;
    }

    private void build(int idx,int l,int r) {
        if (l==r) {
            seg[idx] = new Node(1,1,1,arr[l],arr[l],1);
            return;
        }
        int mid=(l+r)/2;
        build(idx*2,l,mid);
        build(idx*2+1,mid+1,r);
        seg[idx] = merge(seg[idx*2],seg[idx*2+1]);
    }

    private void update(int idx,int l,int r,int pos,char c) {
        if (l==r) {
            arr[l]=c;
            seg[idx] = new Node(1,1,1,c,c,1);
            return;
        }
        int mid=(l+r)/2;
        if (pos<=mid) update(idx*2,l,mid,pos,c);
        else update(idx*2+1,mid+1,r,pos,c);
        seg[idx] = merge(seg[idx*2],seg[idx*2+1]);
    }

    private Node merge(Node a,Node b) {
        Node res = new Node(0,0,0,a.leftChar,b.rightChar,a.len+b.len);
        res.lRun = a.lRun;
        if (a.lRun==a.len && a.rightChar==b.leftChar) res.lRun += b.lRun;
        res.rRun = b.rRun;
        if (b.rRun==b.len && a.rightChar==b.leftChar) res.rRun += a.rRun;
        res.maxRun = Math.max(a.maxRun,b.maxRun);
        if (a.rightChar==b.leftChar) res.maxRun = Math.max(res.maxRun,a.rRun+b.lRun);
        return res;
    }
}
