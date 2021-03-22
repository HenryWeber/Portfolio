// RECURSIVE
const recurGridTraveler = (m, n) => {
    if (m == 1 && n == 1) return 1;
    if (m == 0 || n == 0) return 0;
    return recurGridTraveler(m - 1, n) + recurGridTraveler(m, n - 1);
};

// Time Complexity   O(2^(m+n)) **Exponential
// Space Complexity  O(n+m)
// space complexity for recursive code is height of the tree
console.log(recurGridTraveler(1,1));//1
console.log(recurGridTraveler(2,3));//3
console.log(recurGridTraveler(3,2));//3
console.log(recurGridTraveler(3,3));//6




// MEMO 
const memoGridTraveler = (m, n, memo={}) => {
    const key = m + ',' + n

    if(key in memo) return memo[key];
    if (m == 1 && n == 1) return 1;
    if (m == 0 || n == 0) return 0;
    
    memo[key] = memoGridTraveler(m - 1, n, memo) + memoGridTraveler(m, n - 1, memo);
    return memo[key];
};
// M * N possible combinations of m and n
// Time Complexity O(m*n) **Linear
// Space Complexity  O(n+m)
console.log(memoGridTraveler(1,1));//1
console.log(memoGridTraveler(2,3));//3
console.log(memoGridTraveler(3,2));//3
console.log(memoGridTraveler(3,3));//6
console.log(memoGridTraveler(18,18));//2333606220
