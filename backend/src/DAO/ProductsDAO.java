package DAO;
import java.sql.SQLException;
import java.util.ArrayList;

import database.polyBayDatabase;
import models.Product;

public class ProductsDAO {
    private polyBayDatabase db;
    public ProductsDAO(){
        try {
            this.db = new polyBayDatabase("localhost", 3306, "poly_bay", "TOM", "123");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            e.printStackTrace();
        }
    }
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            var statement = this.db.prepareStatement("SELECT * FROM product ORDER BY name ASC");
            var result = statement.executeQuery();
            while (result.next()) {
                products.add(new Product(result.getInt("id"), result.getString("name"), result.getString("owner"), result.getFloat("bid")));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des produits");
            e.printStackTrace();
        }

        return products;
        
    }
    public boolean bid(int id){
        try {
            var statement = this.db.prepareStatement("UPDATE product SET bid = bid + 50 WHERE id = ?");
            statement.setInt(1, id);
            boolean result = statement.execute();
            return result;            
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enchère");
            e.printStackTrace();
            return false;
        }
    }
}