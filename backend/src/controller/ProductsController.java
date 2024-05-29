package controller;
import java.util.ArrayList;
import DAO.ProductsDAO;
import models.Product;
import webserver.WebServerContext;



public class ProductsController {
    ProductsDAO dao = new ProductsDAO();

    public ProductsController() {
        
    }
    public ArrayList<Product> findAll(WebServerContext context) {
        
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            products = dao.findAll();
            context.getResponse().json(products);
        } catch (Exception e) {
            System.err.println("Erreur lors de la récupération des produits");
            e.printStackTrace();
        }
        return products;
    
    }   
    public int findBidById(WebServerContext context){
        try {
            int id = Integer.parseInt(context.getRequest().getParam("productId"));
            int bid = dao.getBidById(id);
            return bid;
        } catch (Exception e) {
            context.getResponse().serverError("Erreur lors de la récupération de l'enchère");
            System.out.println("Erreur lors de la récupération de l'enchère");
            e.printStackTrace();
            return 0;
        }
    }
    public boolean bid(WebServerContext context){
        
        try {
            int id = Integer.parseInt(context.getRequest().getParam("productId"));
            boolean bidding = dao.bid(id); 
            int bid = dao.getBidById(id);
            String idString = Integer.toString(id);
            String bidString = Integer.toString(bid);    
            context.getResponse().json(bid);
            context.getSSE().emit("bids", "id: " + idString + " bid: " + bidString + "\n\n))");
            context.getResponse().ok("Enchère effectuée");
            
            return bidding; 

        } catch (Exception e) {
            context.getResponse().serverError("Erreur lors de l'enchère");
            System.out.println("Erreur lors de l'enchère");
            e.printStackTrace();
            return false;
        }
    }
}
