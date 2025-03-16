class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (var i = 0; i < nums.length; i++) {
		var direction = Math.signum(nums[i]);
		var slow = i;
		var fast = i;

		do {
			slow = getNextIndex(nums, direction, slow);
			fast = getNextIndex(nums, direction, fast);
			if (fast != -1)
				fast = getNextIndex(nums, direction, fast);
			if (fast == -1 || nums[slow] == 0 || nums[fast] == 0)
				break;
		} while (slow != fast);

		if (slow != -1 && slow == fast) 
			return true;
		nums[i] = 0;
	}
	return false;
    }
    private int getNextIndex(int[] nums, float direction, int i) {
	var currentDirection = Math.signum(nums[i]);

	if (currentDirection * direction < 0)
		return -1;

	var n = nums.length;
	var nextIndex = (i + nums[i]) % n;

	if (nextIndex < 0)
		nextIndex += n;

	return nextIndex == i ? -1 : nextIndex;
}
}