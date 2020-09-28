const flatten = (arr) => {
    const flattened = [];
    arr.forEach((element) => {
        if (Array.isArray(element)) {
            flatten(element).forEach((value) => flattened.push(value));
        } else {
            flattened.push(element);
        }
    });
    return flattened;
}

const exampleArray = [1,2,[3,4,[5,6,7],8],9,10];

console.log(flatten(exampleArray));