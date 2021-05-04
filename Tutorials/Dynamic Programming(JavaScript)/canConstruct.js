//Can a word bank construct a target word
const canConstruct = (target, wordBank) => {
    if(target == '') {
        return true;
    } 
    for (let word of wordBank) {
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            if (canConstruct(suffix, wordBank) === true) {
                return true;
            }
        }
    }
    return false;
};
// m is traget.length, n = wordBank.length
// Time Complexity = O(m * n^(m)) **Exponential
// Space Complexity O(m^2) **Quadratic
console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); //true
console.log(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));//false
console.log(canConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); //true  
console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"]));// false 
const canConstruct2 = (target, wordBank, memo={}) => {
    if(target in memo) return memo[target];
    if(target == '') return true;
    
    for (let word of wordBank) {
        if (target.indexOf(word) === 0) {
            const suffix = target.slice(word.length);
            if (canConstruct2(suffix, wordBank, memo) === true) {
               memo[target] = true;
               return true;
            }
        }
    }
    memo[target] = false;
    return false;
};
console.log();
console.log(canConstruct2("abcdef", ["ab", "abc", "cd", "def", "abcd"])); //true
console.log(canConstruct2("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));//false
console.log(canConstruct2("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); //true  
console.log(canConstruct2("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"]));// false

// Time Complexity = O(n * m^2) **Polynomial
// Space Complexity O(m^2) **Quadratic