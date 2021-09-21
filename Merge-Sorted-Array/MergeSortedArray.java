class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = 0;
        int p2 = 0;
        
        int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);
        int nums1i = 0;
        
        while(p1 < m || p2 < n) {
            if(p1 < m && p2 < n) {
                int v1 = nums1Copy[p1];
                int v2 = nums2[p2];
                if(v1 < v2) {
                    nums1[nums1i] = v1;
                    p1++;
                } else {
                    nums1[nums1i] = v2;
                    p2++;
                }
            } else if (p1 < m) {
                nums1[nums1i] = nums1Copy[p1];
                p1++;
            } else {
                nums1[nums1i] = nums2[p2];
                p2++;
            }
            nums1i++;
        }
        
    }
}