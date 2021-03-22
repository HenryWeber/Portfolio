const howSum = (targetSum, numbers) => {
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    for(let num of numbers) {
        const remainder = targetSum - num;
        const remainderResult = howSum(remainder, numbers);
        if(remainderResult !== null) {
            return [ ...remainderResult, num];
        }
    }

    return null;
};

// m = targetSum, n = numbers.length
// Time Complexity = O(n^(m) * m) **Exponential
// Space Complexity = O(m) ** Linear

console.log(howSum(7,[2, 3]));          //[3,2,2]
console.log(howSum(7,[5, 3, 4, 7]));          //[4,3]
console.log(howSum(7,[2, 4]));          //null
console.log(howSum(8,[2, 3, 5]));          //[2,2,2,2]
//console.log(howSum(300,[7, 14]));          //null
console.log();
const howSum2 = (targetSum, numbers, memo={}) => {
    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    for(let num of numbers) {
        const remainder = targetSum - num;
        const remainderResult = howSum2(remainder, numbers, memo);
        if(remainderResult !== null) {
            memo[targetSum] = [ ...remainderResult, num];
            return memo[targetSum]
        }
    }
    memo[targetSum] = null;
    return null;
};
//Time Complexity = O(n*m^2) **Polynomial
//Space Complexity O(m^2)   **Polynomial

console.log(howSum2(7,[2, 3]));          //[3,2,2]
console.log(howSum2(7,[5, 3, 4, 7]));          //[4,3]
console.log(howSum2(7,[2, 4]));          //null
console.log(howSum2(8,[2, 3, 5]));          //[2,2,2,2]
console.log(howSum2(300,[7, 14]));          //null