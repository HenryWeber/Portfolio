//Take targetSum and an array of numbers
//Return boolean whether the targetSum can be generated from the array of numbers
const canSum = (targetSum, numbers) => {
    if(targetSum === 0) return true;
    if(targetSum < 0) return false;

    for(let num of numbers) {
        const remainder = targetSum - num;
        if(canSum(remainder, numbers) === true){
            return true;
        }
    }

    return false;
};
// m = targetSum, n = array length
// Height of tree worst case is m
// Branching factor(number of child nodes)
// Branching factor is n
//Time Complexity O(n^m) **Exponential
//Space Complexity O(m) 
console.log(canSum(7,[2, 3]));          //true
console.log(canSum(7,[5, 3, 4, 7]));    //true
console.log(canSum(7,[2, 4]));          //false
console.log(canSum(7,[2, 3, 5]));       //true
//console.log(canSum(300,[7, 14]));       //false
console.log();



const canSum2 = (targetSum, numbers, memo={}) => {
    if(targetSum in memo) return memo[targetSum];
    if(targetSum === 0) return true;
    if(targetSum < 0) return false;

    for(let num of numbers) {
        const remainder = targetSum - num;
        if(canSum2(remainder, numbers, memo) === true){
            memo[targetSum] = true;
            return true;
        }
    }
    memo[targetSum] = false;
    return false;
};
//Time Complexity O(n*m) **Polynomial
//Space Complexity O(m)
console.log(canSum2(7,[2, 3]));          //true
console.log(canSum2(7,[5, 3, 4, 7]));    //true
console.log(canSum2(7,[2, 4]));          //false
console.log(canSum2(7,[2, 3, 5]));       //true
console.log(canSum2(300,[7, 14]));       //false