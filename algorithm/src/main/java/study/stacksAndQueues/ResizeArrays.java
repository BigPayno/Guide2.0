package study.stacksAndQueues;
/**
 * @author payno
 * @date 2020/2/16 15:13
 * @description
 *      在pop/push时更新数组大小
 */
public class ResizeArrays {
    /**
     *  resize when pop or push arrays:
     *      选择每次添加或移除元素进行更改，开销过大
     *      因此添加时按照两倍拓展（均摊开销）:
     *       1+2+4...+n~lgn*n
     *      选择1/2（抖动）
     *          当只剩下1/2时，缩小到一半，这样如果在只有1/2时pop/push会频繁的进行更改容量
     *          出现抖动
     *      选择1/4
     *          当只剩下1/4时，缩小至一半，这样始终保持在25-100%
     *  the linked list does not need resize but cost time and memory on link
     */
}
