
const fib = (n) => {
  if (n <= 2) return 1;
  return fib(n - 1) + fib(n - 2);
};
console.log("Recursive Test")
console.log(fib(6));
console.log(fib(7));
console.log(fib(8))

const fib2 = (n, memo = {}) => {
  if(n in memo) return memo[n];
  if(n <= 2) return 1;
  memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
  return memo[n]
};
//O(n) time complexity
//O(n) space complexity
console.log("Memoization")
console.log(fib2(6));
console.log(fib2(7));
console.log(fib2(8))