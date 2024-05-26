import { ProductsService } from "./services/products-service.js"
import { ProductsView } from "./views/ProductsView.js"

async function run(){
    const result = await ProductsService.findAll()
    console.log(result)
    ProductsView.displayProducts()
}

window.addEventListener('load', run)

