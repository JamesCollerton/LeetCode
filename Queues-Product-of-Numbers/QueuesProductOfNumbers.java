class ProductOfNumbers {

    private List<Integer> list;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(list.get(list.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        return k >= list.size() ? 0 : list.get(list.size() - 1) / list.get(list.size() - k - 1);
    }
    
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */