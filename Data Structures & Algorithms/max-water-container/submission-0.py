class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left, right = 0, len(heights)-1
        best = 0
        while left < right:
            width = right - left
            height = min(heights[left], heights[right])
            best = max(best, width * height)

            if heights[left] < heights[right]:
                left = left + 1
            else:
                right = right - 1
            

        
        return best
        