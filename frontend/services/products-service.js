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
                location.reload();
                return true;
            }
        else{
            return false;
        }
    }

}