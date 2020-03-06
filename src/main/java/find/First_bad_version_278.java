package find;

import org.junit.Assert;
import org.junit.Test;

public class First_bad_version_278 {
    public int firstBadVersion(int n) {
        if(n<=0)
            return -1;
        int i=1;
        int j=n;
        while (i<j){
            //写成（i+j)/2会超出int,超时
            int mid = i + (j - i) /2;
            if (isBadVersion(mid))
                j = mid;
            else
                i = mid + 1;
        }
        return j;
    }

    boolean isBadVersion(int v){
        if ((v >= 1702766719))
            return true;
        else
            return false;
    }
    @Test
    public void test() {
        Assert.assertEquals(1702766719,firstBadVersion(2126753390));
    }
}
