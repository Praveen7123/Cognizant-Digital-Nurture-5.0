class Product {
    int productId;
    String productName;
    String category;

    Product(int productId,String productName,String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
public class ProductSearch{
    static Product linearSearch(Product[] products,int targetId){
        for(int i = 0;i<products.length;i++){
            if(products[i].productId == targetId){
                return products[i];
        }
    }
         return null;
}

static Product binarySearch(Product[] products,int targetId){
    int low = 0;
    int high = products.length-1;

    while(low <= high){
        int mid = (low+high)/2;

        if(products[mid].productId == targetId){
            return products[mid];
        }
        else if(products[mid].productId<targetId){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
    }
    return null;
}
public static void main(String[] args){
        Product[] products = {
            new Product(10, "Pen",     "Stationery"),
            new Product(23, "Mouse",   "Electronics"),
            new Product(35, "Book",    "Education"),
            new Product(47, "Laptop",  "Electronics"),
            new Product(58, "Bottle",  "Kitchen")
        };
        Product a = linearSearch(products, 35);
        if (a != null)
            System.out.println("Linear found:"+a.productName);
        else
            System.out.println("Linear not found");
        Product b = binarySearch(products, 35);
        if (b != null)
            System.out.println("binary found:"+b.productName);
        else
            System.out.println("binary not found");

        
    }
}