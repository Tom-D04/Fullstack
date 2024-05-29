export class ProductsService{
    constructor(){
    }
    static async findAll(){     
        const response = await fetch('http://localhost:8081/products')
        if(response.status === 200)
            {
            const data = await response.json();
            return data;
            }
    }
    static async bid(id){
        const response = await fetch('http://localhost:8081/bid/'+id+'', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                bid: 1
            })
        })
        if(response.status === 200)
            {
                this.findBid(id);
                return true;
            }
        else{
            return false;
        }
    }
    static async findBid(id){
        const response = await fetch('http://localhost:8081/bidding/'+id+'', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        if(response.status === 200)
            {
            const data = await response.json();
            return data;
            }
        else{
            console.log("Erreur récupération du montant")
        }
    }

}