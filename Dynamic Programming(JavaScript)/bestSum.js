const bestSum = (targetSum, numbers) => {
    if(targetSum === 0) return [];
    if(targetSum < 0) return null;

    let shortestCombination = null;

    for(let num of numbers){
        const remainder = targetSum - num;
        const remainderCombination = bestSum(remainder, numbers);
        if(remainderCombination !== null) {
            const combination = [ ...remainderCombination, num];
            //if combo is shorter than current shortest, update it
            if(shortestCombination === null || combination.length < shortestCombination.length) {
                shortestCombination = combination;
            }
        }
    }
    return shortestCombination;
};
// m is targetSum, n is numbers.length
// Time Complexity = O(n^(m) * m)
// Space Complexity = O(m * m) equal to O(m^2)
console.log(bestSum(7,[5, 3, 4, 7]));           // [7]
console.log(bestSum(8,[2, 3, 5]));              // [3, 5]
console.log(bestSum(8,[1, 4, 5]));              // [4, 4]
//console.log(bestSum(100,[1, 2, 5, 25]));       // [25, 25, 25, 25]
console.log();


const bestSum2 = (targetSum, numbers, memo={}) => {
    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;

    let shortestCombination = null;

    for(let num of numbers){
        const remainder = targetSum - num;
        const remainderCombination = bestSum2(remainder, numbers, memo);
        if (remainderCombination !== null) {
            const combination = [ ...remainderCombination, num];
            //if combo is shorter than current shortest, update it
            if (shortestCombination === null || combination.length < shortestCombination.length) {
                shortestCombination = combination;
            }
        }
    }
    memo[targetSum] = shortestCombination;
    return shortestCombination;
};
//Time Complexity O(m * n * m) equal to O(m^(2) * n)
// Space Complexity O(m^2)
console.log(bestSum2(7,[5, 3, 4, 7]));           // [7]
console.log(bestSum2(8,[2, 3, 5]));              // [3, 5]
console.log(bestSum2(8,[1, 4, 5]));              // [4, 4]
console.log(bestSum2(100,[1, 2, 5, 25]));       // [25, 25, 25, 25]
console.log();