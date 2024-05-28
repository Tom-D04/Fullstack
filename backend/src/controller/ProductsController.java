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
    public boolean bid(WebServerContext context){
        
        try {
            int id = Integer.parseInt(context.getRequest().getParam("productId"));
            boolean bidding = dao.bid(id); 
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
