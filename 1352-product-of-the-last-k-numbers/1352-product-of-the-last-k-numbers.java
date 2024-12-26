class ProductOfNumbers {
List<Integer> products;
    int product;
    public ProductOfNumbers() {
         this.products = new ArrayList<Integer>();
        this.product = 1;
        products.add(product);
    }
    
    public void add(int num) {
          if(num<=0){
            products = new ArrayList();
            product = 1;
            products.add(product);
        } else{
            product *= num;
            products.add(product);
        }
    }
    
    public int getProduct(int k) {
         int size = products.size();
        return k<size ? product/products.get(size-1-k): 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */