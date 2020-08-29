package practice1;

public class Xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof_m11 {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length <= 0)
            return -1;

        for(int i=1; i<numbers.length ;i++){
            if (numbers[i-1] > numbers[i])
                return numbers[i];
        }
        return numbers[0];
    }

    public int minArray_1(int[] numbers) {
        if(numbers == null || numbers.length <= 0)
            return -1;
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            int mid = i + (j-i)/2;
            if (numbers[mid] > numbers[j])
                i = mid + 1;
            else if (numbers[mid] < numbers[j])
                j = mid;
            else
                j--;
        }
        return numbers[i];
    }
}
