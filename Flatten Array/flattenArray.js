const flatten = (arr) => {
    return arr.reduce((flattened, element) => {
        if (Array.isArray(element)) {
            flattened = flattened.concat(flatten(element));
        } else {
            flattened.push(element);
        }
        return flattened;
    }, []);
}

const exampleArray = [1,2,[3,4,[5,6,7],8],9,10];

console.log(flatten(exampleArray));