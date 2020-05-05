const openMapped = {
    '(': ')',
    '{': '}',
    '[': ']',
}

const validParentheses = (s) => {
    const stack = [];
    for (let i = 0; i < s.length; i++) {
        if (openMapped[s[i]]) {      
            stack.push(openMapped[s[i]]);
        } else if (stack.pop() !== s[i]){
            return false;
        }
    }
    return stack.length === 0;
}
