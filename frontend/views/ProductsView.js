import { ProductsService } from '../services/products-service.js';

export class ProductsView{
    constructor(){
        this.productsService = new ProductsService();
    }
    static async displayProducts(){
        const products = await ProductsService.findAll();
        products.forEach(product => {
            this.#displayProduct(product);
            console.log(product);
        });
    }
    static #displayProduct(productInfo){
        const produit = document.createElement('div');
        produit.classList.add('product');
        document.querySelector('.products').appendChild(produit);
        produit.innerHTML = `
            <h2>${productInfo.name}</h2>
            <p>${productInfo.owner}</p>
            <p>${productInfo.bid}</p>
            <button>Enchérir</button>
        `;
        return produit;
    }
        
}
