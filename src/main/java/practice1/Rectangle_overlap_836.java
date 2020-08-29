package practice1;

public class Rectangle_overlap_836 {
    //是否不重叠更好判断
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(
                rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);     //top
    }

    //将两个矩阵映射到x y 轴判断是否有线段重合
    public boolean isRectangleOverlap_1(int[] rec1, int[] rec2) {
        // x轴的 rec1[0] rec1[2]  rec2[0] rec2[2]
        // y轴的 rec1[1] rec1[3]  rec2[1] rec2[3]
        return (Math.max(rec1[0],rec2[0]) < Math.min(rec1[2],rec2[2])) &&
                (Math.max(rec1[1],rec2[1]) < Math.min(rec1[3],rec2[3]));
    }
}
