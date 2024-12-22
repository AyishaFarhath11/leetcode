int removeDuplicates(int* arr, int n) {

    if (n == 0 || n == 1)
        return n;

    int temp[n];

    // Start from the second element and compare it with the previous one
    int j = 0;
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] != arr[i + 1]) {
            temp[j++] = arr[i];
        }
    }

    // Store the last element as it will always be unique
    temp[j++] = arr[n - 1];

    // Copy the updated array back to the original array
    for (int i = 0; i < j; i++) {
        arr[i] = temp[i];
    }

    return j;
}