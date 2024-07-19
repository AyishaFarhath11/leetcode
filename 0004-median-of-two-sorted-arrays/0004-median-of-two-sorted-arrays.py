class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n, m = len(nums1), len(nums2)
        total = n + m
        i = j = 0
        current = prev = 0

        for _ in range(total // 2 + 1):
            prev = current
            if i < n and (j >= m or nums1[i] < nums2[j]):
                current = nums1[i]
                i += 1
            else:
                current = nums2[j]
                j += 1

        if total % 2 == 1:
            return current
        else:
            return (prev + current) / 2.0
        