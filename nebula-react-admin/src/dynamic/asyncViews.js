const cachedViews = {}
const basepath = 'http://localhost:8080/views';

const asyncViews = function(resource){
    if (!cachedViews[resource]) {
        cachedViews[resource] = fetch(basepath + "/" + resource, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                },
            }).then(response => response.json())
    }
    
    return cachedViews[resource];
}
export default asyncViews;