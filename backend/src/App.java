
import controller.ProductsController;
import webserver.WebServer;
import webserver.WebServerContext;

public class App {
    public static void main(String[] args) throws Exception {
        WebServer webserver = new WebServer();
        webserver.listen(8080);
        ProductsController myController = new ProductsController();
        /*webserver.getRouter().get(
            "/products",
            (WebServerContext context) -> { myController.findAll(context); }
        );*/
        webserver.getRouter().post(
            "/bid",
            (WebServerContext context) -> { myController.bid(1,context); }
        );


    }
}