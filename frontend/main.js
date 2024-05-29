import { ProductsView } from "./views/ProductsView.js"
import { SSEClient } from "./lib/sse-client.js"

async function run(){
    ProductsView.displayProducts()
    const mySSEClient = new SSEClient("localhost:8081");
    mySSEClient.subscribe("bids", ProductsView.updateBid);
    mySSEClient.connect();

}

window.addEventListener('load', run)

