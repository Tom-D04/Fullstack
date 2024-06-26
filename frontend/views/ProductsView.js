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
            <h2> ${productInfo.name} </h2>
            <p> ${productInfo.owner} </p>
            <p id = 'bid'+${productInfo.id}> ${productInfo.bid} </p>
            <button id = ${productInfo.id}> Enchérir </button>
        `;
        document.getElementById(productInfo.id).addEventListener('click', async () => {
            const bid = await ProductsService.bid(productInfo.id);
        });
        return produit;
    }
    static updateBid(data){
        console.log(data);
        var enchere = document.getElementById('bid' + data.id);
        if (enchere) {
            enchere.innerHTML = data.newBid;
        } else {
            console.log('Element not found:', 'bid' + data.id);
        }
        }
    }
        
