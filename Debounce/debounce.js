const debounce = (func, interval) => {
    let cooldown = false;
    let timeout = null;
    return function() {

        // If the function is not in cooldown, invoke
        if (!cooldown) {
            func.apply(null, arguments);
        }

        // Reset cooldown
        cooldown = true;
        clearTimeout(timeout);
        timeout = setTimeout(
            () => { cooldown = false }
            ,interval
        );
    }
}